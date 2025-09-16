package com.example.medapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User {
    private String specialty;
    private String licenseNumber;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;


    public Doctor() {}

    public Doctor(String firstName, String lastName, String email, String phone, String specialty) {
        super(firstName, lastName, email, phone);
        this.specialty = specialty;
    }


    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public List<Appointment> getAppointments() { return appointments; }
    public void setAppointments(List<Appointment> appointments) { this.appointments = appointments; }
}