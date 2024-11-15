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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController 
{
    private final UserService service;

    @GetMapping
    public List<GetAllUsersResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetUserResponse getById(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse add(@Valid @RequestBody CreateUserRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateUserResponse update(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable Long id)
    {
        return service.delete(id);
    }
}
