package com.example.salestracking.dto.request.role;

import com.example.salestracking.model.Permission;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
public class CreateRoleRequest
{
    @NotBlank(message = "Role Name is mandatory")
    private String roleName;
    private List<PermissionRequest> permissions;
    private Boolean roleStatus;
}
