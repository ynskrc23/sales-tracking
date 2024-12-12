package com.example.salestracking.dto.request.user;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateUserRequest
{
    @NotBlank(message = "Full Name is mandatory")
    private String fullName;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    private String password;

    @Pattern(regexp = "^\\d{11}$")
    private String phone;

    @Positive(message = "Order must be positive")
    private Integer userOrder;

    private Boolean userStatus;

    @NotNull(message = "Role is mandatory")
    private int roleId;
}
