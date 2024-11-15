package com.example.salestracking.service;

import com.example.salestracking.dto.request.user.CreateUserRequest;
import com.example.salestracking.dto.request.user.UpdateUserRequest;
import com.example.salestracking.dto.response.user.CreateUserResponse;
import com.example.salestracking.dto.response.user.GetAllUsersResponse;
import com.example.salestracking.dto.response.user.GetUserResponse;
import com.example.salestracking.dto.response.user.UpdateUserResponse;

import java.util.List;

public interface UserService
{
    List<GetAllUsersResponse> getAll();
    GetUserResponse getById(Long id);
    CreateUserResponse add(CreateUserRequest request);
    UpdateUserResponse update(Long id, UpdateUserRequest request);
    String delete(Long id);
}
