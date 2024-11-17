package com.example.salestracking.service;

import com.example.salestracking.dto.response.auth.LoginResponse;

public interface AuthService
{
    LoginResponse login(String email, String password);
}
