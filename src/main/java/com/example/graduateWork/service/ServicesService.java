package com.example.graduateWork.service;

import com.example.graduateWork.entity.Services;
import com.example.graduateWork.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {
    private final ServicesRepository servicesRepository;

    @Autowired
    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public List<Services> getAllAppointments() {
        List<Services> services = servicesRepository.findAll();
        return services;
    }

    public Services getServiceById(Long idService) {
        Services services = servicesRepository.getServicesByIdService(idService);
        if (services != null) {
            return services;
        }
        return null;
    }

    public Services save(Services services) {
        return servicesRepository.save(services);
    }

    public Long delete(Long idService) {
        servicesRepository.deleteById(idService);
        return idService;
    }
}