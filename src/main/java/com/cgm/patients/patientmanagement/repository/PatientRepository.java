package com.cgm.patients.patientmanagement.repository;

import com.cgm.patients.patientmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByFirstName(String name);

    Patient findByLastName(String name);

    Patient findByEmail(String email);
}
