package com.example.salestracking.model;

import lombok.Data;

@Data
public class Permission
{
    private Long menuId;
    private Boolean permissionShow;
    private Boolean permissionAdd;
    private Boolean permissionUpdate;
    private Boolean permissionDelete;
    private Boolean permissionDatatable;
}