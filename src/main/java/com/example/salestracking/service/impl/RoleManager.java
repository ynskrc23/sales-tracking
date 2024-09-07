package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.role.CreateRoleRequest;
import com.example.salestracking.dto.request.role.UpdateRoleRequest;
import com.example.salestracking.dto.response.role.CreateRoleResponse;
import com.example.salestracking.dto.response.role.GetAllRolesResponse;
import com.example.salestracking.dto.response.role.GetRoleResponse;
import com.example.salestracking.dto.response.role.UpdateRoleResponse;
import com.example.salestracking.model.Role;
import com.example.salestracking.repository.RoleRepository;
import com.example.salestracking.service.RoleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleManager implements RoleService
{
    private final RoleRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllRolesResponse> getAll()
    {
        List<Role> roles = repository.findAll();
        return roles.stream().map(role -> mapper.map(role, GetAllRolesResponse.class)).toList();
    }

    @Override
    public GetRoleResponse getById(Long id)
    {
        Role role = repository.findById(id).orElseThrow();
        return mapper.map(role, GetRoleResponse.class);
    }

    @Override
    public CreateRoleResponse add(CreateRoleRequest request) {
        Role role = mapper.map(request, Role.class);
        role.setRoleId(0L);
        role.setRoleName(request.getRoleName());

        String rolePermission = request.getPermissions().stream()
                .map(permission -> String.format(
                        "{\"menu_id\":%d,\"permission_show\":%b,\"permission_add\":%b,\"permission_update\":%b,\"permission_delete\":%b,\"permission_datatable\":%b}",
                        permission.getMenuId(),
                        permission.isPermissionShow(),
                        permission.isPermissionAdd(),
                        permission.isPermissionUpdate(),
                        permission.isPermissionDelete(),
                        permission.isPermissionDatatable()
                ))
                .collect(Collectors.joining("*"));

        role.setRolePermission(rolePermission);
        role.setRoleStatus(request.getRoleStatus());

        repository.save(role);
        return mapper.map(role, CreateRoleResponse.class);
    }

    @Override
    public UpdateRoleResponse update(Long id, UpdateRoleRequest request)
    {
        return null;
    }

    @Override
    public String delete(Long id)
    {
        return null;
    }
}
