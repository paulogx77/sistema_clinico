package com.clinica.repository;

import com.clinica.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

// PatientRepository estende JpaRepository<Entidade, TipoDaChavePrimária>
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // 4.2 PATIENTREPOSITORY.JAVA [cite: 25]

    // Busca exata pelo CPF (essencial para cadastro) [cite: 25]
    Optional<Patient> findByCpf(String cpf);

    // Busca por nome contendo o termo, ignorando maiúsculas/minúsculas (para a UI) [cite: 25]
    List<Patient> findByNameContainingIgnoreCase(String name);

    // Busca por nome OU CPF (útil para campos de busca unificados) [cite: 25]
    List<Patient> findByNameContainingIgnoreCaseOrCpfContaining(String name, String cpf);

    // Verifica se um CPF já existe no sistema [cite: 25]
    boolean existsByCpf(String cpf);
}