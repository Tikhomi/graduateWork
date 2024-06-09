package com.example.graduateWork.controller.common;

import com.example.graduateWork.dto.AppointmentDTO;
import com.example.graduateWork.entity.*;
import com.example.graduateWork.repository.ClientRepository;
import com.example.graduateWork.repository.DoctorRepository;
import com.example.graduateWork.repository.StatusDicRepository;
import com.example.graduateWork.service.AppointmentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.graduateWork.repository.ServicesRepository;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value ="/appointment", method = { RequestMethod.GET, RequestMethod.POST })
@CrossOrigin(origins = "http://localhost:3000/AppointmentF")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final ServicesRepository servicesRepository;
    private final StatusDicRepository statusDicRepository;
    private final DoctorRepository doctorRepository;
    private final ClientRepository clientRepository;
    private static final Logger logger = Logger.getLogger(DoctorController.class.getName());


    @Autowired
    public AppointmentController(AppointmentService appointmentService, ServicesRepository servicesRepository,
                                 StatusDicRepository statusDicRepository, DoctorRepository doctorRepository,
                                 ClientRepository clientRepository) {
        this.appointmentService = appointmentService;
        this.servicesRepository = servicesRepository;
        this.statusDicRepository = statusDicRepository;
        this.doctorRepository = doctorRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<AppointmentDTO> appointmentDTO = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointmentDTO);
    }

    @GetMapping("/get/{idAppointment}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable("idAppointment") Long idAppointment) {
        AppointmentDTO appointmentS = appointmentService.getAppointmentById(idAppointment);
        if (appointmentS != null) {
            return ResponseEntity.ok(appointmentS);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public void addAppointment(@RequestBody Appointment appointment){
        logger.info("Received request to add appointment: " + appointment);
        appointmentService.save(appointment);
    }

    @DeleteMapping("/del/{idAppointment}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("idAppointment") Long idAppointment) {
        appointmentService.delete(idAppointment);
        return ResponseEntity.noContent().build();
    }
}