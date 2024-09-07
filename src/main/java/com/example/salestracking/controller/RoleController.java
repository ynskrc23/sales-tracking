package com.example.salestracking.controller;

import com.example.salestracking.dto.request.role.CreateRoleRequest;
import com.example.salestracking.dto.response.role.CreateRoleResponse;
import com.example.salestracking.dto.response.role.GetAllRolesResponse;
import com.example.salestracking.dto.response.role.GetRoleResponse;
import com.example.salestracking.service.RoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleController
{
    private final RoleService service;

    @GetMapping
    public List<GetAllRolesResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetRoleResponse getById(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRoleResponse add(@Valid @RequestBody CreateRoleRequest request)
    {
        return service.add(request);
    }
}
