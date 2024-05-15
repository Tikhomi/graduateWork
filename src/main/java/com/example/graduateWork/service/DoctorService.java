package com.example.graduateWork.service;

import com.example.graduateWork.dto.DoctorDTO;
import com.example.graduateWork.entity.Doctor;
import com.example.graduateWork.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public List <DoctorDTO> getAllDoctors(){
        List <Doctor> doctors = doctorRepository.findAll();
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
        return doctorRepository.save(doctor);
    }

    public Long delete (Long idDoctor){
        doctorRepository.deleteById(idDoctor);
        return idDoctor;
    }

    private DoctorDTO convertToDTO(Doctor doctor){
        return new DoctorDTO(doctor.getNameDoc(), doctor.getLastnameDoc(), doctor.getPatronymicDoc()
        ,doctor.getExperience(), doctor.getSpecificationDics());
    }

}
