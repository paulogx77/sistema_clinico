package com.clinica.model.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public enum UserRole {
    ADMIN,          // Administrador, tem acesso total, como gerenciar outros usuários
    RECEPTIONIST,   // Recepcionista, focado em pacientes e agendamentos
    DOCTOR;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Por convenção, cada ROLE tem a si mesma como autoridade principal.
        List<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority("ROLE_" + this.name())
        );

        // Em sistemas mais complexos, você adicionaria permissões específicas aqui:
        /*
        if (this == ADMIN) {
            // Se fosse ADMIN, teria a permissão de deletar:
            authorities.add(new SimpleGrantedAuthority("PERMISSION_DELETE"));
        }
        */

        return authorities;
    }
}
