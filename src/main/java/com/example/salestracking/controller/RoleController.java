package com.example.salestracking.controller;

import com.example.salestracking.dto.request.role.CreateRoleRequest;
import com.example.salestracking.dto.request.role.UpdateRoleRequest;
import com.example.salestracking.dto.response.role.CreateRoleResponse;
import com.example.salestracking.dto.response.role.GetAllRolesResponse;
import com.example.salestracking.dto.response.role.GetRoleResponse;
import com.example.salestracking.dto.response.role.UpdateRoleResponse;
import com.example.salestracking.service.RoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleController extends BaseController
{
    private final RoleService service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        try {
            List<GetAllRolesResponse> roles = service.getAll();
            return jsonResponse(roles, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        try {
            GetRoleResponse role = service.getById(id);
            return jsonResponse(role, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Role not found for ID: " + id));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@Valid @RequestBody CreateRoleRequest request)
    {
        try {
            CreateRoleResponse role = service.add(request);
            return jsonResponse(role, HttpStatus.CREATED);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.BAD_REQUEST, Map.of());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateRoleRequest request)
    {
        try {
            UpdateRoleResponse role = service.update(id, request);
            return jsonResponse(role, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Role not found for ID: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        try {
            service.delete(id);
            return jsonResponse("Role deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to delete role for ID: " + id));
        }
    }
}

