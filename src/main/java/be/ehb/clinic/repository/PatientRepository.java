package be.ehb.clinic.repository;

import be.ehb.clinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {

}
