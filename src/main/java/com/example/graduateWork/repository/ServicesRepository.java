package com.example.graduateWork.repository;

import com.example.graduateWork.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    Services getServicesById(Long id_service);
}