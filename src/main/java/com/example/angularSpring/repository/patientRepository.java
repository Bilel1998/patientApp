package com.example.angularSpring.repository;

import com.example.angularSpring.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface patientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findPatientById(Long id);

}
