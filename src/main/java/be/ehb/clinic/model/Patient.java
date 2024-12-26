package be.ehb.clinic.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;


@Entity(name = "patients")
public class Patient {

    @Id
    @Column(name = "national_register_number", nullable = false, unique = true)
    @NotBlank(message = "National register number cannot be empty!")
    @NationalRegisterNumberConstraint
    private String nationalRegisterNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;


    public Patient() {}

    public Patient(@NotBlank String nationalRegisterNumber, String firstName, String lastName, LocalDate dateOfBirth) {
        this.nationalRegisterNumber = nationalRegisterNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalRegisterNumber() {
        return nationalRegisterNumber;
    }

    public void setNationalRegisterNumber(String nationalRegisterNumber) {
        this.nationalRegisterNumber = nationalRegisterNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return nationalRegisterNumber == patient.nationalRegisterNumber;
    }

    @Override
    public int hashCode() {
        return nationalRegisterNumber.hashCode();
    }
}

