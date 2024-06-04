package com.example.graduateWork.controller.common;

import com.example.graduateWork.dto.DoctorDTO;
import com.example.graduateWork.entity.Doctor;
import com.example.graduateWork.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value ="/doctor", method = { RequestMethod.GET, RequestMethod.POST })
@CrossOrigin(origins = "http://localhost:3000/DoctorF")

public class DoctorController {
    private final DoctorService doctorService;
    private static final Logger logger = Logger.getLogger(DoctorController.class.getName());

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<DoctorDTO> doctorDTOs = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctorDTOs);
    }

    @GetMapping("/get/{idDoctor}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable("idDoctor") Long idDoctor) {
        DoctorDTO doctorDTO = doctorService.getDoctorById(idDoctor);
        if (doctorDTO != null) {
            return ResponseEntity.ok(doctorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public void addDoctor(@RequestBody Doctor doctor) {
        logger.info("Received request to add doctor: " + doctor);
        doctorService.save(doctor);
    }

    @DeleteMapping("/del/{idDoctor}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("idDoctor") Long idDoctor) {
        doctorService.delete(idDoctor);
        return ResponseEntity.noContent().build();
    }
}
