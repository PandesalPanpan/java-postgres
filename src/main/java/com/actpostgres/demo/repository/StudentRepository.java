package com.actpostgres.demo.repository;

import com.actpostgres.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    @Query(value = "SELECT MAX(CAST(SUBSTRING(student_id, 5, 5) AS BIGINT)) " +
           "FROM students " +
           "WHERE student_id LIKE :yearPrefix || '%'", 
           nativeQuery = true)
    Long findMaxSequenceForYear(@Param("yearPrefix") String yearPrefix);
    
    // Find student by formatted studentId (e.g., "202600001MN0")
    Optional<Student> findByStudentId(String studentId);
}

