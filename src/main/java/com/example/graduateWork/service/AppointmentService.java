package com.example.graduateWork.service;

import com.example.graduateWork.dto.AppointmentDTO;
import com.example.graduateWork.dto.DoctorAppointmentDTO;
import com.example.graduateWork.dto.SimpleAppointmentDTO;
import com.example.graduateWork.entity.*;
import com.example.graduateWork.repository.AppointmentRepository;
import com.example.graduateWork.repository.DoctorRepository;
import com.example.graduateWork.repository.ClientRepository;
import com.example.graduateWork.repository.ServicesRepository;
import com.example.graduateWork.repository.StatusDicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
                appointment.getDescription(), appointment.getUserDoc(), appointment.getUserCl(), appointment.getStatus());
    }


    public SimpleAppointmentDTO getLastAppointmentForClient(Long idUser) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findTopByUserClIdClientOrderByDtApDesc(idUser);

        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            String doctorName = appointment.getUserDoc().getLastnameDoc() + " " +
                    appointment.getUserDoc().getNameDoc() + " " +
                    appointment.getUserDoc().getPatronymicDoc() + " (" +
                    appointment.getUserDoc().getSpecializationName() + ")";
            String serviceName = appointment.getService().getName();
            String statusName = appointment.getStatus().getNmStatus();

            LocalDateTime appointmentDate = appointment.getDtAp();

            return new SimpleAppointmentDTO(appointmentDate, doctorName, serviceName, statusName);
        } else {
            return null;
        }
    }

    public DoctorAppointmentDTO getLastAppointmentForDoctor(Long idUser) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findTopByUserDocIdDoctorOrderByDtApDesc(idUser);

        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            String clientName = appointment.getUserCl().getLastnameCl() + " " +
                    appointment.getUserCl().getNameCl() + " " +
                    appointment.getUserCl().getPatronymicCl();
            String serviceName = appointment.getService().getName();
            String statusName = appointment.getStatus().getNmStatus();

            return new DoctorAppointmentDTO(appointment.getDtAp(), clientName, serviceName, statusName);
        } else {
            return null;
        }
    }
}
