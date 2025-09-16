package com.example.medapp.service;

import com.example.medapp.exception.ResourceNotFoundException;
import com.example.medapp.model.Doctor;
import com.example.medapp.repository.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks

    private DoctorService doctorService;



    private Doctor doctor;



    @BeforeEach

    void setUp() {

        doctor = new Doctor();

        doctor.setId(1L);

        doctor.setFirstName("Carlos");

        doctor.setLastName("Santos");

        doctor.setEmail("carlos@hospital.com");

        doctor.setSpecialty("Ortopedia");

        doctor.setLicenseNumber("CRM-67890");

    }



    @Test

    void shouldSaveDoctor() {

        when(doctorRepository.save(any(Doctor.class))).thenReturn(doctor);



        Doctor savedDoctor = doctorService.saveDoctor(doctor);



        assertNotNull(savedDoctor);

        assertEquals("Carlos", savedDoctor.getFirstName());

        verify(doctorRepository, times(1)).save(doctor);

    }



    @Test

    void shouldGetAllDoctors() {

        when(doctorRepository.findAll()).thenReturn(List.of(doctor));



        List<Doctor> doctors = doctorService.getAllDoctors();



        assertEquals(1, doctors.size());

        verify(doctorRepository, times(1)).findAll();

    }



    @Test

    void shouldGetDoctorById() {

        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));



        Doctor foundDoctor = doctorService.getDoctorById(1L);



        assertNotNull(foundDoctor);

        assertEquals("Ortopedia", foundDoctor.getSpecialty());

    }



    @Test

    void shouldThrowExceptionWhenDoctorNotFound() {

        when(doctorRepository.findById(1L)).thenReturn(Optional.empty());



        assertThrows(ResourceNotFoundException.class, () -> {

            doctorService.getDoctorById(1L);

        });

    }



    @Test

    void shouldDeleteDoctor() {

        when(doctorRepository.existsById(1L)).thenReturn(true);

        doNothing().when(doctorRepository).deleteById(1L);



        doctorService.deleteDoctor(1L);



        verify(doctorRepository, times(1)).deleteById(1L);

    }



    @Test

    void shouldThrowExceptionWhenDeletingNonExistentDoctor() {

        when(doctorRepository.existsById(1L)).thenReturn(false);



        assertThrows(ResourceNotFoundException.class, () -> {

            doctorService.deleteDoctor(1L);

        });

    }

}