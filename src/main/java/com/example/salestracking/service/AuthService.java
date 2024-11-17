package com.example.salestracking.service;

import org.springframework.http.ResponseEntity;

public interface AuthService
{
    ResponseEntity<?> login(String email, String password);
}
