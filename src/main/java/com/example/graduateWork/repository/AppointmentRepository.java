package com.example.graduateWork.repository;

import com.example.graduateWork.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment getAppointmentByIdAppointment(Long idAppointment);

    List<Appointment> findByDtRecBetween(Date dt_rec, Date dt_ap);
}