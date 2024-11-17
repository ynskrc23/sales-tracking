package com.example.salestracking.controller;

import com.example.salestracking.dto.request.auth.LoginRequest;
import com.example.salestracking.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController
{
    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request)
    {
        return service.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request)
    {
        // İsteğe bağlı olarak oturum bilgilerini temizleyebilirsiniz:
        request.getSession().invalidate(); // Eğer session-based bir yapı kullanıyorsanız.

        // Response olarak başarı dönebiliriz.
        return ResponseEntity.ok("Logout başarılı");
    }
}
