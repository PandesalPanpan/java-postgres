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
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherRepository teacherRepository;
    private final SubjectGradeRepository subjectGradeRepository;

    public TeacherController(TeacherRepository teacherRepository, 
                            SubjectGradeRepository subjectGradeRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectGradeRepository = subjectGradeRepository;
    }

    @GetMapping
    public List<TeacherResponse> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(teacher -> {
                    Long studentCount = subjectGradeRepository.countDistinctStudentsByTeacherId(teacher.getId());
                    return new TeacherResponse(teacher.getId(), teacher.getFullName(), studentCount);
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{teacherId}")
    public TeacherResponse getTeacher(@PathVariable Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
        Long studentCount = subjectGradeRepository.countDistinctStudentsByTeacherId(teacherId);
        return new TeacherResponse(teacher.getId(), teacher.getFullName(), studentCount);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse createTeacher(@Valid @RequestBody CreateTeacherRequest request) {
        Teacher teacher = new Teacher(request.getFullName());
        Teacher saved = teacherRepository.save(teacher);
        return new TeacherResponse(saved.getId(), saved.getFullName(), 0L);
    }

    @DeleteMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable Long teacherId) {
        if (!teacherRepository.existsById(teacherId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found");
        }
        teacherRepository.deleteById(teacherId);
    }
}
