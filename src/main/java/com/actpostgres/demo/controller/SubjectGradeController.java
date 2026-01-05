package com.actpostgres.demo.controller;

import com.actpostgres.demo.dto.*;
import com.actpostgres.demo.model.*;
import com.actpostgres.demo.repository.*;
import jakarta.validation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

@RestController
@RequestMapping("/subjects")
public class SubjectGradeController {

    private final SubjectGradeRepository subjectGradeRepository;

    public SubjectGradeController(SubjectGradeRepository subjectGradeRepository) {
        this.subjectGradeRepository = subjectGradeRepository;
    }

    @PatchMapping("/{subjectGradeId}")
    public SubjectGradeResponse updateGrade(@PathVariable Long subjectGradeId,
                                           @Valid @RequestBody UpdateGradeRequest request) {
        SubjectGrade subjectGrade = subjectGradeRepository.findById(subjectGradeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject grade not found"));

        subjectGrade.setGrade(request.getGrade());
        SubjectGrade updated = subjectGradeRepository.save(subjectGrade);

        return new SubjectGradeResponse(
                updated.getSubjectName(),
                updated.getSubjectCode(),
                updated.getSemester(),
                updated.getSchoolYear(),
                updated.getGrade()
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

