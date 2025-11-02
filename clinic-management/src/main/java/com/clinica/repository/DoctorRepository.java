package com.clinica.repository;

import com.clinica.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findBySpecialty(String specialty);
    List<Doctor> findByActiveTrue();

}
