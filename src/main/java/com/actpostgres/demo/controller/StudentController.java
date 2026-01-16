package com.actpostgres.demo.controller;

import com.actpostgres.demo.dto.*;
import com.actpostgres.demo.model.*;
import com.actpostgres.demo.repository.*;
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

    public StudentController(StudentRepository studentRepository, 
                             SubjectGradeRepository subjectGradeRepository) {
        this.studentRepository = studentRepository;
        this.subjectGradeRepository = subjectGradeRepository;
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(s -> new StudentResponse(s.getId(), s.getFullName()))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest request) {
        Student student = new Student(request.getFullName());
        Student saved = studentRepository.save(student);
        return new StudentResponse(saved.getId(), saved.getFullName());
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
        return new StudentResponse(student.getId(), student.getFullName());
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

