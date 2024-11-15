package com.example.salestracking.dto.request.user;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateUserRequest
{
    @NotBlank(message = "Full Name is mandatory")
    private String fullName;

    @NotBlank(message = "Last Name is mandatory")
    @Email
    private String email;

    private String password;

    @Pattern(regexp = "^\\d{11}$")
    private String phone;

    @Positive(message = "Order must be positive")
    private Integer userOrder;

    private Boolean userStatus;

    @NotNull(message = "Category is mandatory")
    private int userRoleId;
}
