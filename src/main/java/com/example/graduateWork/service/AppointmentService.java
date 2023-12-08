package com.example.graduateWork.service;

import com.example.graduateWork.dto.AppointmentDTO;
import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id_appointment) {
        Appointment appointment= appointmentRepository.getAppointmentById(id_appointment);
        if (appointment != null) {
            return convertToDTO(appointment);
        }
        return null;
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Long delete(Long id_appointment) {
        appointmentRepository.deleteById(id_appointment);
        return id_appointment;
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        return new AppointmentDTO(appointment.getDt_rec(), appointment.getDt_ap(),
                appointment.getDescription(), appointment.getUsers_doc(), appointment.getUsers_cl());

    }
}