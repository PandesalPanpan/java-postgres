package com.actpostgres.demo.repository;

import com.actpostgres.demo.model.SubjectGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectGradeRepository extends JpaRepository<SubjectGrade, Long> {
    List<SubjectGrade> findByStudentId(Long studentId);
    
    @Query("SELECT COUNT(DISTINCT sg.student.id) FROM SubjectGrade sg WHERE sg.teacher.id = :teacherId")
    Long countDistinctStudentsByTeacherId(@Param("teacherId") Long teacherId);
}

