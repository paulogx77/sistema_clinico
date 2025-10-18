package com.clinica.service.auth;

import com.clinica.model.User;
import com.clinica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Método obrigatório para o Spring Security carregar os dados do usuário
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Usa o método findByEmail que você definiu no UserRepository
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

        // Cria a lista de autoridades (roles)
        List<String> roles = new ArrayList<>();
        // Adiciona o prefixo "ROLE_" que o Spring Security espera
        roles.add("ROLE_" + user.getRole().name());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isActive(), // Account is enabled
                true, // Account is not expired
                true, // Credentials are not expired
                true, // Account is not locked
                user.getRole().getAuthorities() // Assumindo que você implementou getAuthorities no UserRole
                // Caso contrário, use: AuthorityUtils.createAuthorityList(roles.toArray(new String[0]))
        );
    }
}