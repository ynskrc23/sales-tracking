package com.example.salestracking.dto.request.role;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
public class UpdateRoleRequest
{
    @NotBlank(message = "Role Name is mandatory")
    private String roleName;
    private List<PermissionRequest> permissions;
    private Boolean roleStatus;
}
