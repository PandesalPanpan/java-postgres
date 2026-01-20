package com.actpostgres.demo.dto;

import jakarta.validation.constraints.*;
import java.math.*;

public class UpdateGradeRequest {

    private BigDecimal grade;

    public UpdateGradeRequest() {
    }

    public UpdateGradeRequest(BigDecimal grade) {
        this.grade = grade;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }
}

