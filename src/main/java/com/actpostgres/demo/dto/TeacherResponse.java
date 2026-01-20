package com.actpostgres.demo.dto;

public class TeacherResponse {

    private Long id;
    private String fullName;
    private Long studentCount;

    public TeacherResponse() {
    }

    public TeacherResponse(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.studentCount = 0L;
    }

    public TeacherResponse(Long id, String fullName, Long studentCount) {
        this.id = id;
        this.fullName = fullName;
        this.studentCount = studentCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Long studentCount) {
        this.studentCount = studentCount;
    }
}
