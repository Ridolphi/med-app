package com.example.medapp.controller;

import com.example.medapp.model.Doctor;
import com.example.medapp.service.DoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class DoctorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private DoctorController doctorController;

    private Doctor doctor;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
        objectMapper = new ObjectMapper();

        doctor = new Doctor();
        doctor.setId(1L);
        doctor.setFirstName("Maria");
        doctor.setLastName("Silva");
        doctor.setEmail("maria@hospital.com");
        doctor.setSpecialty("Cardiologia");
        doctor.setLicenseNumber("CRM-12345");
    }

    @Test
    void shouldCreateDoctor() throws Exception {
        when(doctorService.saveDoctor(any(Doctor.class))).thenReturn(doctor);

        mockMvc.perform(post("/api/doctors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(doctor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Maria"))
                .andExpect(jsonPath("$.specialty").value("Cardiologia"));

        verify(doctorService, times(1)).saveDoctor(any(Doctor.class));
    }

    @Test
    void shouldGetAllDoctors() throws Exception {
        when(doctorService.getAllDoctors()).thenReturn(List.of(doctor));

        mockMvc.perform(get("/api/doctors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Maria"))
                .andExpect(jsonPath("$[0].email").value("maria@hospital.com"));

        verify(doctorService, times(1)).getAllDoctors();
    }

    @Test
    void shouldGetDoctorById() throws Exception {
        when(doctorService.getDoctorById(1L)).thenReturn(doctor);

        mockMvc.perform(get("/api/doctors/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Maria"))
                .andExpect(jsonPath("$.licenseNumber").value("CRM-12345"));

        verify(doctorService, times(1)).getDoctorById(1L);
    }

    @Test
    void shouldUpdateDoctor() throws Exception {
        when(doctorService.saveDoctor(any(Doctor.class))).thenReturn(doctor);

        mockMvc.perform(put("/api/doctors/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(doctor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.specialty").value("Cardiologia"));

        verify(doctorService, times(1)).saveDoctor(any(Doctor.class));
    }

    @Test
    void shouldDeleteDoctor() throws Exception {
        doNothing().when(doctorService).deleteDoctor(1L);

        mockMvc.perform(delete("/api/doctors/1"))
                .andExpect(status().isOk());

        verify(doctorService, times(1)).deleteDoctor(1L);
    }
}