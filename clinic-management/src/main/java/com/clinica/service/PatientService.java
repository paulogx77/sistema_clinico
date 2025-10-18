package com.clinica.service;

import com.clinica.exception.ResourceNotFoundException;
import com.clinica.model.Patient;
import com.clinica.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    // Injeção de dependência do Repositório
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // 5.1 PATIENTSERVICE.JAVA - MÉTODOS

    // List<Patient> findAll();
    public List<Patient> findAll() {
        return patientRepository.findAll(); //
    }

    // Optional<Patient> findById(Long id);
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id); //
    }

    // Optional<Patient> findByCpf(String cpf);
    public Optional<Patient> findByCpf(String cpf) {
        return patientRepository.findByCpf(cpf); //
    }

    // List<Patient> searchByName(String name);
    public List<Patient> searchByName(String name) {
        // Usa o método customizado do repositório para busca flexível
        return patientRepository.findByNameContainingIgnoreCase(name); //
    }

    // Patient save(Patient patient);
    @Transactional
    public Patient save(Patient patient) {
        // Validação de unicidade do CPF antes de salvar
        if (patient.getId() == null && patientRepository.existsByCpf(patient.getCpf())) {
            // Lança exceção de negócio (que você implementará depois)
            throw new RuntimeException("CPF já cadastrado.");
        }
        return patientRepository.save(patient); //
    }

    // void deleteById(Long id);
    @Transactional
    public void deleteById(Long id) {
        if (!patientRepository.existsById(id)) {
            // Lança exceção se o recurso não for encontrado (ResourceNotFoundException)
            throw new ResourceNotFoundException("Paciente não encontrado com ID: " + id); // [cite: 5]
        }
        patientRepository.deleteById(id); //
    }
}