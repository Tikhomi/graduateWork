package com.example.graduateWork.service;

import com.example.graduateWork.dto.DoctorDTO;
import com.example.graduateWork.entity.Client;
import com.example.graduateWork.entity.Doctor;
import com.example.graduateWork.repository.DoctorRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private static final Logger logger = Logger.getLogger(DoctorService.class.getName());


    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        for (Doctor doctor : doctors) {
            Hibernate.initialize(doctor.getSpecificationDics());
        }
        return doctors.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public DoctorDTO getDoctorById (Long idDoctor){
        Doctor doctor = doctorRepository.getDoctorByIdDoctor(idDoctor);
        if(doctor != null){
            return convertToDTO(doctor);
        }
        return null;
    }

    public Doctor save(Doctor doctor){
        System.out.println("Trying to save doctor: " + doctor);
        logger.info("Trying to save doctor: " + doctor);
        Doctor savedDoctor = doctorRepository.save(doctor);

        logger.info("Doctor saved successfully: " + savedDoctor);
        return savedDoctor;
    }

    public Long delete (Long idDoctor){
        doctorRepository.deleteById(idDoctor);
        return idDoctor;
    }

    public Doctor getDoctorByUserId(Long userId) {
        return doctorRepository.findByUsersIdUser(userId).orElse(null);
    }

    private DoctorDTO convertToDTO(Doctor doctor){
        return new DoctorDTO(doctor.getIdDoctor(),doctor.getNameDoc(), doctor.getLastnameDoc(), doctor.getPatronymicDoc()
        ,doctor.getExperience(), doctor.getSpecificationDics());
    }
}
