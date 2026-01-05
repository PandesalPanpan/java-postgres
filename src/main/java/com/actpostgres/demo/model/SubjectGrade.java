package com.actpostgres.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import java.math.*;

@Entity
@Table(name = "subject_grades")
public class SubjectGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    @Column(nullable = false)
    private String subjectName;

    @Column(nullable = false)
    private String subjectCode;

    @Column(nullable = false)
    private String semester;

    @Column(nullable = false)
    private String schoolYear;

    @Column(nullable = false)
    private BigDecimal grade;

    public SubjectGrade() {
    }

    public SubjectGrade(Student student, String subjectName, String subjectCode, 
                       String semester, String schoolYear, BigDecimal grade) {
        this.student = student;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.semester = semester;
        this.schoolYear = schoolYear;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }
}

