package com.actpostgres.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import java.math.*;

public class AddSubjectGradeRequest {

    @NotBlank(message = "Subject name is required")
    @JsonProperty("subject_name")
    private String subjectName;

    @NotBlank(message = "Subject code is required")
    @JsonProperty("subject_code")
    private String subjectCode;

    @NotBlank(message = "Semester is required")
    private String semester;

    @NotBlank(message = "School year is required")
    @JsonProperty("school_year")
    private String schoolYear;

    @NotNull(message = "Grade is required")
    private BigDecimal grade;

    public AddSubjectGradeRequest() {
    }

    public AddSubjectGradeRequest(String subjectName, String subjectCode, 
                                 String semester, String schoolYear, BigDecimal grade) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.semester = semester;
        this.schoolYear = schoolYear;
        this.grade = grade;
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

