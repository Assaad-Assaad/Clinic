package be.ehb.clinic.controller;


import be.ehb.clinic.model.Appointment;
import be.ehb.clinic.model.Patient;
import be.ehb.clinic.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping("/patients")
public class PatientController {


    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {

        this.patientService = patientService;
    }

    @GetMapping
    List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        return ResponseEntity.of(patientService.getPatientById(id));
    }

    @PostMapping
    void savePatient(@RequestBody @Valid Patient patient) {
        patientService.save(patient);
    }

    @PostMapping("/appointment/{id}")
    ResponseEntity<String> makeAppointment(@PathVariable String id, @Valid @RequestBody Appointment appointment) {
        patientService.makeAppointment(id, appointment);
        return ResponseEntity.ok("Appointment has been successfully created.");
    }

    @GetMapping("/appointments/today")
    public ResponseEntity<List<Appointment>> getAppointmentsToday() {
        List<Appointment> todayAppointments = patientService.getAllTodayAppointments();
        if (todayAppointments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(todayAppointments);
    }

}

