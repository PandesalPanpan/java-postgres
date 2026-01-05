package com.actpostgres.demo.repository;

import com.actpostgres.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

