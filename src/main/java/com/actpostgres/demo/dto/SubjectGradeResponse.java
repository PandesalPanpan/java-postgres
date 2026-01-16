package com.actpostgres.demo.dto;

import java.math.*;

public class SubjectGradeResponse {

    private Long id;
    private String subjectName;
    private String subjectCode;
    private String semester;
    private String schoolYear;
    private BigDecimal grade;

    public SubjectGradeResponse() {
    }

    public SubjectGradeResponse(Long id, String subjectName, String subjectCode, 
                               String semester, String schoolYear, BigDecimal grade) {
        this.id = id;
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

