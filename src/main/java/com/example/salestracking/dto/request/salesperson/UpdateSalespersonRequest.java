package com.example.salestracking.dto.request.salesperson;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateSalespersonRequest
{
    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "First Name is mandatory")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @Pattern(regexp = "^\\d{11}$")
    private String phone;

    private java.time.LocalDate hireDate;
}
