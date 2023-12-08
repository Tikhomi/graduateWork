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

    @GetMapping("/all")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<AppointmentDTO> appointmentDTO = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointmentDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable("id_appointment") Long id_appointment) {
        AppointmentDTO appointmentS = appointmentService.getAppointmentById(id_appointment);
        if (appointmentS != null) {
            return ResponseEntity.ok(appointmentS);
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