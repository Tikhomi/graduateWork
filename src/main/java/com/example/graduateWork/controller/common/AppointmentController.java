package com.example.graduateWork.controller.common;

import com.example.graduateWork.dto.AppointmentDTO;
import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable("id") Long id) {
        AppointmentDTO appointment = appointmentService.getAppointmentById(id);
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public void addAppointment(@RequestBody Appointment appointment) {
        appointmentService.save(appointment);
    }


    @DeleteMapping("/{id_appointment}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id_appointment") Long id_appointment) {
        appointmentService.delete(id_appointment);
        return ResponseEntity.noContent().build();
    }
}