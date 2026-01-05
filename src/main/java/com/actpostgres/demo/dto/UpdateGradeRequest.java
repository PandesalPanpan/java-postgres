package com.actpostgres.demo.dto;

import jakarta.validation.constraints.*;
import java.math.*;

public class UpdateGradeRequest {

    @NotNull(message = "Grade is required")
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

