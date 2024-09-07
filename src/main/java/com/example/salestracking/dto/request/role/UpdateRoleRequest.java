package com.example.salestracking.dto.request.role;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Map;

@Data
public class UpdateRoleRequest
{
    @NotBlank(message = "Role Name is mandatory")
    private String roleName;
    private Map<Long, Map<String, Boolean>> permissions;  // permission_show, permission_add, etc.
    private Boolean roleStatus;
}
