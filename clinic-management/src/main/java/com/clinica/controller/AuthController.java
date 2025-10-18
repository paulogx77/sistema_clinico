package com.clinica.controller;

import com.clinica.dto.LoginRequest;
import com.clinica.dto.LoginResponse;
import com.clinica.service.auth.JwtService;
import com.clinica.service.auth.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth") // Endpoint principal de autenticação
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager; //

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // Endpoint: POST /auth/login
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateAndGetToken(@RequestBody LoginRequest loginRequest) {

        // 1. Tenta autenticar o usuário
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {

            // 2. Se autenticado, carrega o UserDetails e gera o Token
            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
            final String token = jwtService.generateToken(userDetails);

            // Cria a resposta com o Token e dados do usuário
            LoginResponse response = new LoginResponse();
            response.setToken(token);
            response.setType("Bearer");

            // Você precisará buscar os dados do usuário para preencher o ID, Nome e Role.
            // Para simplificar, vou usar o que está disponível no UserDetails (username = email, role).
            response.setEmail(userDetails.getUsername());
            response.setName(userDetails.getUsername()); // Ajuste necessário
            response.setRole(null); // Ajuste necessário

            return ResponseEntity.ok(response);
        } else {
            // Lança exceção de autenticação falha
            throw new RuntimeException("Credenciais inválidas.");
        }
    }
}