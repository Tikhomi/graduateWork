package com.example.graduateWork.controller.common;

import com.example.graduateWork.entity.Services;
import com.example.graduateWork.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    private final ServicesService servicesService;

    @Autowired
    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Services>> getAllAppointments() {
        List<Services> services = servicesService.getAllAppointments();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> getAppointmentById(@PathVariable("id_service") Long id_service) {
        Services service = servicesService.getServiceById(id_service);
        if (service != null) {
            return ResponseEntity.ok(service);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public void addAppointment(@RequestBody Services services) {
        servicesService.save(services);
    }


    @DeleteMapping("/{id_service}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id_service") Long id_service) {
        servicesService.delete(id_service);
        return ResponseEntity.noContent().build();
    }
}