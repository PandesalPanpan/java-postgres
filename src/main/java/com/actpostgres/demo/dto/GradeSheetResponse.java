package com.actpostgres.demo.dto;

import java.util.*;

public class GradeSheetResponse {

    private String student;
    private List<SubjectGradeResponse> subjects;

    public GradeSheetResponse() {
    }

    public GradeSheetResponse(String student, List<SubjectGradeResponse> subjects) {
        this.student = student;
        this.subjects = subjects;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public List<SubjectGradeResponse> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectGradeResponse> subjects) {
        this.subjects = subjects;
    }
}

