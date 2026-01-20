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
import java.util.Set;

@RestController
@RequestMapping("/api/subjects")
public class SubjectGradeController {

    private final SubjectGradeRepository subjectGradeRepository;

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
        // Grade can be null (empty/ungraded)
        if (grade != null) {
            BigDecimal normalized = grade.setScale(2, RoundingMode.HALF_UP);
            if (!ALLOWED_GRADES.contains(normalized)) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Invalid grade. Allowed values: 1, 1.25, 1.5, 1.75, 2, 2.25, 2.5, 2.75, 3, 5"
                );
            }
        }
    }

    public SubjectGradeController(SubjectGradeRepository subjectGradeRepository) {
        this.subjectGradeRepository = subjectGradeRepository;
    }

    @PatchMapping("/{subjectGradeId}")
    public SubjectGradeResponse updateGrade(@PathVariable Long subjectGradeId,
                                           @Valid @RequestBody UpdateGradeRequest request) {
        SubjectGrade subjectGrade = subjectGradeRepository.findById(subjectGradeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject grade not found"));

        validateGrade(request.getGrade());
        subjectGrade.setGrade(request.getGrade());
        SubjectGrade updated = subjectGradeRepository.save(subjectGrade);

        return new SubjectGradeResponse(
                updated.getId(),
                updated.getSubjectName(),
                updated.getSubjectCode(),
                updated.getSemester(),
                updated.getSchoolYear(),
                updated.getGrade(),
                updated.getTeacher() != null ? updated.getTeacher().getFullName() : null
        );
    }

    @DeleteMapping("/{subjectGradeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubjectGrade(@PathVariable Long subjectGradeId) {
        if (!subjectGradeRepository.existsById(subjectGradeId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject grade not found");
        }
        subjectGradeRepository.deleteById(subjectGradeId);
    }
}

