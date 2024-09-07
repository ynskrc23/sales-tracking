package com.example.salestracking.dto.request.role;

import lombok.Data;

@Data
public class PermissionRequest
{
    private Long menuId;
    private boolean permissionShow;
    private boolean permissionAdd;
    private boolean permissionUpdate;
    private boolean permissionDelete;
    private boolean permissionDatatable;
}
