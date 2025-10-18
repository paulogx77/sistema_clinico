package com.clinica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO para receber a requisição de login
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    // O email será o "username" para o Spring Security
    private String email;

    private String password;
}