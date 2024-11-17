package com.example.salestracking.service.impl;

import com.example.salestracking.model.User;
import com.example.salestracking.repository.UserRepository;
import com.example.salestracking.service.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService
{
    private UserRepository repository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> login(String email, String password)
    {
        // Kullanıcıyı e-posta ile bul
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        // Şifre doğrulama
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.status(401).body("Geçersiz kullanıcı adı veya şifre");
        }

        // JWT oluşturma
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Güçlü bir anahtar oluşturuyoruz

        String token = Jwts.builder()
                .setSubject(user.getEmail()) // Token'a kullanıcı email'ini ekliyoruz
                .signWith(key) // Anahtar ile imzalıyoruz
                .compact();

        // Başarılı yanıt
        return ResponseEntity.ok().body(token);
    }
}
