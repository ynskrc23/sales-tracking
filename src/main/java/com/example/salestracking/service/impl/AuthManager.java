package com.example.salestracking.service.impl;

import com.example.salestracking.dto.response.auth.LoginResponse;
import com.example.salestracking.model.User;
import com.example.salestracking.repository.UserRepository;
import com.example.salestracking.service.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.Key;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService
{
    private UserRepository repository;
    private final ModelMapper mapper;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(String email, String password)
    {
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Geçersiz kullanıcı adı veya şifre");
        }

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .signWith(key)
                .compact();

        LoginResponse loginResponse = mapper.map(user, LoginResponse.class);
        loginResponse.setToken(token);

        return mapper.map(loginResponse, LoginResponse.class);
    }
}
