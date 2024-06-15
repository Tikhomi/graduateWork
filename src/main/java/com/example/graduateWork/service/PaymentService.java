package com.example.graduateWork.service;

import com.example.graduateWork.dto.PaymentDTO;
import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.entity.Payment;
import com.example.graduateWork.repository.AppointmentRepository;
import com.example.graduateWork.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, AppointmentRepository appointmentRepository) {
        this.paymentRepository = paymentRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO getPaymentById(Long idPayment) {
        Optional<Payment> payment = paymentRepository.findById(idPayment);
        return payment.map(this::convertToDTO).orElse(null);
    }

    @Transactional
    public Payment save(Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        return savedPayment;
    }

    public void delete(Long idPayment) {
        paymentRepository.deleteById(idPayment);
    }

    private PaymentDTO convertToDTO(Payment payment) {
        Appointment appointment = payment.getAppointment();
        return new PaymentDTO(payment.getDt_pay(), payment.getCostPay(), appointment);
    }

    private Payment convertToEntity(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setDt_pay(paymentDTO.getDt_pay());
        payment.setCostPay(paymentDTO.getCostPay());
        payment.setAppointment(paymentDTO.getAppointment());
        return payment;
    }
}
