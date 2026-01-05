package com.actpostgres.demo.controller;

import com.actpostgres.demo.dto.*;
import com.actpostgres.demo.model.*;
import com.actpostgres.demo.repository.*;
import jakarta.validation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest request) {
        Student student = new Student(request.getFullName());
        Student saved = studentRepository.save(student);
        return new StudentResponse(saved.getId(), saved.getFullName());
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

