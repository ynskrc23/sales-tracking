package com.example.salestracking.controller;

import com.example.salestracking.dto.request.auth.LoginRequest;
import com.example.salestracking.dto.response.auth.LoginResponse;
import com.example.salestracking.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController extends BaseController
{
    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request)
    {
        try {
            LoginResponse login = service.login(request.getEmail(), request.getPassword());
            return jsonResponse(login, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.UNAUTHORIZED, Map.of());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request)
    {
        try {
            request.getSession().invalidate();
            return jsonResponse("Logout başarılı", HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }
}
