package com.actpostgres.demo.dto;

import java.math.BigDecimal;

public class StudentResponse {

    private Long id;
    private String studentId;
    private String fullName;
    private BigDecimal average;
    private Integer subjectCount;

    public StudentResponse() {
    }

    public StudentResponse(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.average = null;
        this.subjectCount = 0;
    }

    public StudentResponse(Long id, String studentId, String fullName) {
        this.id = id;
        this.studentId = studentId;
        this.fullName = fullName;
        this.average = null;
        this.subjectCount = 0;
    }

    public StudentResponse(Long id, String fullName, BigDecimal average, Integer subjectCount) {
        this.id = id;
        this.fullName = fullName;
        this.average = average;
        this.subjectCount = subjectCount;
    }

    public StudentResponse(Long id, String studentId, String fullName, BigDecimal average, Integer subjectCount) {
        this.id = id;
        this.studentId = studentId;
        this.fullName = fullName;
        this.average = average;
        this.subjectCount = subjectCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    public Integer getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(Integer subjectCount) {
        this.subjectCount = subjectCount;
    }
}

