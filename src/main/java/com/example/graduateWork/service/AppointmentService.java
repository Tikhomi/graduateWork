package com.example.graduateWork.service;

import com.example.graduateWork.dto.AppointmentDTO;
import com.example.graduateWork.entity.*;
import com.example.graduateWork.repository.AppointmentRepository;
import com.example.graduateWork.repository.DoctorRepository;
import com.example.graduateWork.repository.ClientRepository;
import com.example.graduateWork.repository.ServicesRepository;
import com.example.graduateWork.repository.StatusDicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final ClientRepository clientRepository;
    private final StatusDicRepository statusDicRepository;
    private final ServicesRepository servicesRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              ClientRepository clientRepository,
                              StatusDicRepository statusDicRepository,
                              ServicesRepository servicesRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.clientRepository = clientRepository;
        this.statusDicRepository = statusDicRepository;
        this.servicesRepository = servicesRepository;
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long idAppointment) {
        Appointment appointment = appointmentRepository.getAppointmentByIdAppointment(idAppointment);
        if (appointment != null) {
            return convertToDTO(appointment);
        }
        return null;
    }

    // Ваш сервис AppointmentService
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }


    public Long delete(Long idAppointment) {
        appointmentRepository.deleteById(idAppointment);
        return idAppointment;
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        return new AppointmentDTO(appointment.getIdAppointment(),appointment.getDtRec(), appointment.getDtAp(),
                appointment.getDescription(), appointment.getUser_doc(), appointment.getUser_cl(), appointment.getStatus());
    }



}
