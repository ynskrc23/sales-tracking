package com.example.salestracking.service;

import com.example.salestracking.dto.request.role.CreateRoleRequest;
import com.example.salestracking.dto.request.role.UpdateRoleRequest;
import com.example.salestracking.dto.response.role.CreateRoleResponse;
import com.example.salestracking.dto.response.role.GetAllRolesResponse;
import com.example.salestracking.dto.response.role.GetRoleResponse;
import com.example.salestracking.dto.response.role.UpdateRoleResponse;

import java.util.List;

public interface RoleService
{
    List<GetAllRolesResponse> getAll();
    GetRoleResponse getById(Long id);
    CreateRoleResponse add(CreateRoleRequest request);
    UpdateRoleResponse update(Long id, UpdateRoleRequest request);
    String delete(Long id);
}
