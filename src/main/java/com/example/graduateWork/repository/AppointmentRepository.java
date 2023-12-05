package com.example.graduateWork.repository;

import com.example.graduateWork.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment getAppointmentById(Long id_appointment);
}