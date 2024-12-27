package be.ehb.clinic.service;

import be.ehb.clinic.model.Appointment;
import be.ehb.clinic.model.Patient;
import be.ehb.clinic.repository.AppointmentRepository;
import be.ehb.clinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }


    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    public void save(Patient patient) {
        patientRepository.save(patient);
    }


    public void makeAppointment(String patientId, Appointment appointment) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + patientId));

        appointment.setPatient(patient);
        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllTodayAppointments() {
        return appointmentRepository.findAllTodayAppointments();
    }


}

