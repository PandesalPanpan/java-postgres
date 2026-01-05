package com.actpostgres.demo.repository;

import com.actpostgres.demo.model.SubjectGrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectGradeRepository extends JpaRepository<SubjectGrade, Long> {
    List<SubjectGrade> findByStudentId(Long studentId);
}

