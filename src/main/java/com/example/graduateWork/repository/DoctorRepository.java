package com.example.graduateWork.repository;

import com.example.graduateWork.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor getDoctorByIdDoctor (Long idDoctor);
}
