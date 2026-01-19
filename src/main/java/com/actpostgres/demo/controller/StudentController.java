package com.actpostgres.demo.controller;

import com.actpostgres.demo.dto.*;
import com.actpostgres.demo.model.*;
import com.actpostgres.demo.repository.*;
import com.actpostgres.demo.service.StudentIdGenerator;
import jakarta.validation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final SubjectGradeRepository subjectGradeRepository;
    private final StudentIdGenerator studentIdGenerator;

    public StudentController(StudentRepository studentRepository, 
                             SubjectGradeRepository subjectGradeRepository,
                             StudentIdGenerator studentIdGenerator) {
        this.studentRepository = studentRepository;
        this.subjectGradeRepository = subjectGradeRepository;
        this.studentIdGenerator = studentIdGenerator;
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        // Fetch all students
        List<Student> students = studentRepository.findAll();
        
        // Fetch all subject grades in one query to avoid N+1
        List<SubjectGrade> allGrades = subjectGradeRepository.findAll();
        
        // Group grades by student ID for efficient lookup
        Map<Long, List<SubjectGrade>> gradesByStudent = allGrades.stream()
                .collect(Collectors.groupingBy(sg -> sg.getStudent().getId()));
        
        // Calculate average and count for each student
        return students.stream()
                .map(student -> {
                    List<SubjectGrade> studentGrades = gradesByStudent.getOrDefault(
                            student.getId(), Collections.emptyList());
                    
                    BigDecimal average = null;
                    int subjectCount = studentGrades.size();
                    
                    if (subjectCount > 0) {
                        // Calculate average: sum all grades and divide by count
                        BigDecimal sum = studentGrades.stream()
                                .map(SubjectGrade::getGrade)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
                        average = sum.divide(
                                new BigDecimal(subjectCount), 
                                2, 
                                RoundingMode.HALF_UP
                        );
                    }
                    
                    return new StudentResponse(
                            student.getId(),
                            student.getStudentId(),
                            student.getFullName(), 
                            average, 
                            subjectCount
                    );
                })
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest request) {
        String studentId = studentIdGenerator.generateStudentId();
        Student student = new Student(studentId, request.getFullName());
        Student saved = studentRepository.save(student);
        return new StudentResponse(saved.getId(), saved.getStudentId(), saved.getFullName());
    }

    private static final Set<BigDecimal> ALLOWED_GRADES = Set.of(
            new BigDecimal("1.00"),
            new BigDecimal("1.25"),
            new BigDecimal("1.50"),
            new BigDecimal("1.75"),
            new BigDecimal("2.00"),
            new BigDecimal("2.25"),
            new BigDecimal("2.50"),
            new BigDecimal("2.75"),
            new BigDecimal("3.00"),
            new BigDecimal("5.00")
    );

    private void validateGrade(BigDecimal grade) {
        if (grade == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Grade is required");
        }
        BigDecimal normalized = grade.setScale(2, RoundingMode.HALF_UP);
        if (!ALLOWED_GRADES.contains(normalized)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid grade. Allowed values: 1, 1.25, 1.5, 1.75, 2, 2.25, 2.5, 2.75, 3, 5"
            );
        }
    }

    @GetMapping("/{studentId}")
    public StudentResponse getStudent(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        return new StudentResponse(student.getId(), student.getStudentId(), student.getFullName());
    }

    @GetMapping("/student-id/{formattedStudentId}")
    public StudentResponse getStudentByFormattedId(@PathVariable String formattedStudentId) {
        // Remove dashes if present (frontend might send "2026-00001-MN-0" instead of "202600001MN0")
        String cleanStudentId = formattedStudentId.replace("-", "");
        
        Student student = studentRepository.findByStudentId(cleanStudentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        
        // Calculate average and subject count
        List<SubjectGrade> subjectGrades = subjectGradeRepository.findByStudentId(student.getId());
        BigDecimal average = null;
        int subjectCount = subjectGrades.size();
        
        if (subjectCount > 0) {
            BigDecimal sum = subjectGrades.stream()
                    .map(SubjectGrade::getGrade)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            average = sum.divide(
                    new BigDecimal(subjectCount), 
                    2, 
                    RoundingMode.HALF_UP
            );
        }
        
        return new StudentResponse(
                student.getId(),
                student.getStudentId(),
                student.getFullName(),
                average,
                subjectCount
        );
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        studentRepository.deleteById(studentId);
    }

    @PostMapping("/{studentId}/subjects")
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectGradeResponse addSubjectGrade(@PathVariable Long studentId,
                                                @Valid @RequestBody AddSubjectGradeRequest request) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        validateGrade(request.getGrade());

        SubjectGrade subjectGrade = new SubjectGrade(
                student,
                request.getSubjectName(),
                request.getSubjectCode(),
                request.getSemester(),
                request.getSchoolYear(),
                request.getGrade()
        );

        SubjectGrade saved = subjectGradeRepository.save(subjectGrade);
        return new SubjectGradeResponse(
                saved.getId(),
                saved.getSubjectName(),
                saved.getSubjectCode(),
                saved.getSemester(),
                saved.getSchoolYear(),
                saved.getGrade()
        );
    }

    @GetMapping("/{studentId}/grades")
    public GradeSheetResponse getStudentGradeSheet(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        List<SubjectGrade> subjectGrades = subjectGradeRepository.findByStudentId(studentId);
        List<SubjectGradeResponse> subjectResponses = subjectGrades.stream()
                .map(sg -> new SubjectGradeResponse(
                        sg.getId(),
                        sg.getSubjectName(),
                        sg.getSubjectCode(),
                        sg.getSemester(),
                        sg.getSchoolYear(),
                        sg.getGrade()
                ))
                .collect(Collectors.toList());

        return new GradeSheetResponse(student.getFullName(), subjectResponses);
    }
}

