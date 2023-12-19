package com.example.graduateWork.controller.common;

import com.example.graduateWork.entity.Services;
import com.example.graduateWork.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicesController {
    private final ServicesService servicesService;

    @Autowired
    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("/services")
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> services = servicesService.getAllAppointments();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<Services> getAppointmentById(@PathVariable("idService") Long idService) {
        Services service = servicesService.getServiceById(idService);
        if (service != null) {
            return ResponseEntity.ok(service);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/service/add")
    public void addAppointment(@RequestBody Services services) {
        servicesService.save(services);
    }


    @DeleteMapping("/services/del/{id_service}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id_service") Long id_service) {
        servicesService.delete(id_service);
        return ResponseEntity.noContent().build();
    }
}