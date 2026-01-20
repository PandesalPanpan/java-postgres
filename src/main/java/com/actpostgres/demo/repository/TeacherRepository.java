package com.actpostgres.demo.repository;

import com.actpostgres.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
