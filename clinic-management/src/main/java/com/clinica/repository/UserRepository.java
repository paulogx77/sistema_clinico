package com.clinica.repository;

import com.clinica.model.User;
import com.clinica.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

// UserRepository estende JpaRepository<Entidade, TipoDaChavePrimária>
public interface UserRepository extends JpaRepository<User, Long> {

    // 4.1 USERREPOSITORY.JAVA [cite: 25]

    // Método para buscar um usuário pelo email (essencial para o login) [cite: 25]
    Optional<User> findByEmail(String email);

    // Método para listar usuários por perfil (ex: todos os DOCTORs) [cite: 25]
    List<User> findByRole(UserRole role);

    // Método para listar apenas usuários ativos [cite: 25]
    List<User> findByActiveTrue();

    // Método para verificar se um email já existe (para validação) [cite: 25]
    boolean existsByEmail(String email);
}