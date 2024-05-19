package com.example.graduateWork.controller.common;

import com.example.graduateWork.dto.AppointmentDTO;
import com.example.graduateWork.dto.DoctorDTO;
import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.entity.Doctor;
import com.example.graduateWork.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/doctor")
@RequestMapping(value ="/doctor", method = { RequestMethod.GET, RequestMethod.POST })
@CrossOrigin(origins = "http://localhost:3000")

public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }
    @GetMapping("/all")
    public ResponseEntity<List <DoctorDTO>> getAllDoctors() {
        List<DoctorDTO> doctorDTO = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctorDTO);
    }

    @GetMapping("/get/{idDoctor}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable("idDoctor") Long idDoctor) {
        DoctorDTO doctorDTOS = doctorService.getDoctorById(idDoctor);
        if (doctorDTOS != null) {
            return ResponseEntity.ok(doctorDTOS);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public void addDoctor (@RequestBody Doctor doctor) {
        doctorService.save(doctor);
    }

    @DeleteMapping("/del/{idDoctor}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("idDoctor") Long idDoctor) {
        doctorService.delete(idDoctor);
        return ResponseEntity.noContent().build();
    }
}
