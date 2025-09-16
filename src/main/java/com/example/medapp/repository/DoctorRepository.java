package com.example.medapp.repository;

import com.example.medapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByLicenseNumber(String licenseNumber);
    List<Doctor> findBySpecialty(String specialty);
    List<Doctor> findByLastNameContainingIgnoreCase(String lastName);
}