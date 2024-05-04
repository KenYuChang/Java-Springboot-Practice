package com.ken.demo.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "First name is required")
        String firstname,
        @NotEmpty(message = "Last name is required")
        String lastname,
        String email,
        Integer schoolId
) {


}
