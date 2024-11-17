package com.example.salestracking.controller;

import com.example.salestracking.dto.request.user.CreateUserRequest;
import com.example.salestracking.dto.request.user.UpdateUserRequest;
import com.example.salestracking.dto.response.user.CreateUserResponse;
import com.example.salestracking.dto.response.user.GetAllUsersResponse;
import com.example.salestracking.dto.response.user.GetUserResponse;
import com.example.salestracking.dto.response.user.UpdateUserResponse;
import com.example.salestracking.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController extends BaseController
{
    private final UserService service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        try {
            List<GetAllUsersResponse> users = service.getAll();
            return jsonResponse(users, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        try {
            GetUserResponse user = service.getById(id);
            return jsonResponse(user, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "User not found for ID: " + id));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@Valid @RequestBody CreateUserRequest request)
    {
        try {
            CreateUserResponse user = service.add(request);
            return jsonResponse(user, HttpStatus.CREATED);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.BAD_REQUEST, Map.of());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request)
    {
        try {
            UpdateUserResponse user = service.update(id, request);
            return jsonResponse(user, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "User not found for ID: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        try {
            service.delete(id);
            return jsonResponse("User deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to delete user for ID: " + id));
        }
    }
}
