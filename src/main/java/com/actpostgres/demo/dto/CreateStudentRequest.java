package com.actpostgres.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public class CreateStudentRequest {

    @NotBlank(message = "Full name is required")
    @JsonProperty("full_name")
    private String fullName;

    public CreateStudentRequest() {
    }

    public CreateStudentRequest(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

