package com.example.salestracking.dto.response.role;

import lombok.Data;

@Data
public class CreateRoleResponse
{
    private Long roleId;
    private String roleName;
    private String rolePermission;
    private Boolean roleStatus;
}
