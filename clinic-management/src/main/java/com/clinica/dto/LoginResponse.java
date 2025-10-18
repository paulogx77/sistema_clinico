package com.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO para retornar o token e informações do usuário
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String token;
    private String type = "Bearer"; // Padrão JWT
    private Long id;
    private String name;
    private String email;
    private String role;
}