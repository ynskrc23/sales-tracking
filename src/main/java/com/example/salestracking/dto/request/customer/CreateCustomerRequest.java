package com.example.salestracking.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
public class CreateCustomerRequest
{
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;
    @Pattern(regexp = "^\\d{11}$")
    private String phone;
    private String address;
    private String city;
    private String country;
}
