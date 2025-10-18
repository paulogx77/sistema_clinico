package com.clinica.service;

import com.clinica.exception.ResourceNotFoundException;
import com.clinica.model.User;
import com.clinica.model.enums.UserRole;
import com.clinica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Adicione o PasswordEncoder para criptografar senhas (dependência do Spring Security)
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Método para salvar (inclui criação e atualização)
    @Transactional
    public User save(User user) {
        // Criptografa a senha antes de salvar um novo usuário
        if (user.getId() == null) {
            if (userRepository.existsByEmail(user.getEmail())) {
                throw new RuntimeException("Email já cadastrado.");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreatedAt(LocalDateTime.now());
        }
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // Busca essencial para o fluxo de Login (segurança)
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email); // [cite: 25]
    }

    // Lista de médicos (útil para o agendamento, Membro 2)
    public List<User> findDoctors() {
        return userRepository.findByRole(UserRole.DOCTOR); // [cite: 25]
    }

    @Transactional
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com ID: " + id); // [cite: 5]
        }
        userRepository.deleteById(id);
    }
}