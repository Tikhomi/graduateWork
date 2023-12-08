package com.example.graduateWork.repository;

import com.example.graduateWork.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment getPaymentById(Long id_payment);
}