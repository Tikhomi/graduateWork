package com.example.graduateWork.controller.common;

import com.example.graduateWork.dto.AppointmentDTO;
import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://127.0.0.1:3000")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<AppointmentDTO> appointmentDTO = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointmentDTO);
    }

    @GetMapping("/appointment/{idAppointment}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable("idAppointment") Long idAppointment) {
        AppointmentDTO appointmentS = appointmentService.getAppointmentById(idAppointment);
        if (appointmentS != null) {
            return ResponseEntity.ok(appointmentS);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/appointment/add")
    public void addAppointment(@RequestBody Appointment appointment) {
        appointmentService.save(appointment);
    }

    @DeleteMapping("/appointment/del/{idAppointment}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("idAppointment") Long idAppointment) {
        appointmentService.delete(idAppointment);
        return ResponseEntity.noContent().build();
    }
}