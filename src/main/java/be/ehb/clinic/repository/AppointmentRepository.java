package be.ehb.clinic.repository;

import be.ehb.clinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


    @Query("SELECT a FROM appointments a WHERE DATE(a.appointmentTime) = CURRENT_DATE")
    List<Appointment> findAllTodayAppointments();
}

