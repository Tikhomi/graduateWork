package com.example.graduateWork.controller.common;

import com.example.graduateWork.dto.PaymentDTO;
import com.example.graduateWork.entity.Payment;
import com.example.graduateWork.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentDTO>> getAllAppointments() {
        List<PaymentDTO> paymentDTO = paymentService.getAllPayment();
        return ResponseEntity.ok(paymentDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getAppointmentById(@PathVariable("id_payment") Long id_payment) {
        PaymentDTO payments = paymentService.getPaymentById(id_payment);
        if (payments != null) {
            return ResponseEntity.ok(payments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public void addAppointment(@RequestBody Payment payment) {
        paymentService.save(payment);
    }


    @DeleteMapping("/{id_appointment}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id_payment") Long id_payment) {
        paymentService.delete(id_payment);
        return ResponseEntity.noContent().build();
    }
}
