package com.clinica.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.clinica.security.JwtAuthFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    // 1. Define o Encoder de Senhas
    // Usamos BCrypt para criptografar senhas de forma segura.
    // O UserService utiliza este bean.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. Define o Authentication Manager
    // Essencial para o processo de login
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // 3. Define a Cadeia de Filtros de Segurança e as Regras de Acesso
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desabilita CSRF (comum em APIs REST sem sessão) [cite: 34]
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Define a política como STATELESS (sem sessão, ideal para JWT)
                )
                .authorizeHttpRequests(auth -> auth
                        // Permite acesso irrestrito ao endpoint de autenticação
                        .requestMatchers("/auth/**").permitAll() // [cite: 34]

                        // Regras de acesso baseadas no perfil
                        .requestMatchers("/api/patients/**").hasAnyRole("ADMIN", "RECEPTIONIST", "DOCTOR") // [cite: 34]
                        .requestMatchers("/api/appointments/**").hasAnyRole("ADMIN", "RECEPTIONIST", "DOCTOR") // [cite: 35]
                        .requestMatchers("/api/queue/**").hasAnyRole("ADMIN", "RECEPTIONIST", "DOCTOR") // [cite: 35]
                        .requestMatchers("/api/medical-records/**").hasAnyRole("ADMIN", "DOCTOR") // [cite: 35]

                        // Endpoint exclusivo para administração de usuários
                        .requestMatchers("/api/users/**").hasRole("ADMIN") // [cite: 35]

                        // Qualquer outra requisição exige autenticação
                        .anyRequest().authenticated() // [cite: 35]
                );

            http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build(); // [cite: 36]
    }
}