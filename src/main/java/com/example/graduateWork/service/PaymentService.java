package com.example.graduateWork.service;

import com.example.graduateWork.dto.PaymentDTO;
import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.entity.Payment;
import com.example.graduateWork.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentDTO> getAllPayment() {
        List<Payment> payment = paymentRepository.findAll();
        return payment.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO getPaymentById(Long idPayment) {
        Payment payment= paymentRepository.getPaymentByIdPayment(idPayment);
        if (payment != null) {
            return convertToDTO(payment);
        }
        return null;
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Long delete(Long idPayment) {
        paymentRepository.deleteById(idPayment);
        return idPayment;
    }

    private PaymentDTO convertToDTO(Payment payment) {
        Appointment appointment = payment.getAppointment();
        return new PaymentDTO(payment.getDt_pay(), payment.getCostPay(), appointment);
    }



}
