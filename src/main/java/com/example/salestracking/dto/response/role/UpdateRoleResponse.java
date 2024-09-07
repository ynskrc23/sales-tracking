package com.example.salestracking.dto.response.role;

import lombok.Data;

@Data
public class UpdateRoleResponse
{
    private Long roleId;
    private String roleName;
    private String rolePermission;
    private Boolean roleStatus;
}
