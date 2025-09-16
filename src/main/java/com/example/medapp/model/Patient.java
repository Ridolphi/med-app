package com.example.medapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends User {
    private String address;
    private LocalDate dateOfBirth;
    private String gender;
    private String bloodType;
    private String healthInsurance;
    private String allergies;
    private String chronicDiseases;


    public Patient() {}

    public Patient(String firstName, String lastName, String email, String phone) {
        super(firstName, lastName, email, phone);
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public String getHealthInsurance() { return healthInsurance; }
    public void setHealthInsurance(String healthInsurance) { this.healthInsurance = healthInsurance; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getChronicDiseases() { return chronicDiseases; }
    public void setChronicDiseases(String chronicDiseases) { this.chronicDiseases = chronicDiseases; }
}