package com.example.graduateWork.controller.common;

import com.example.graduateWork.dto.PaymentDTO;
import com.example.graduateWork.entity.Payment;
import com.example.graduateWork.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentDTO>> getAllPayment() {
        List<PaymentDTO> paymentDTO = paymentService.getAllPayment();
        return ResponseEntity.ok(paymentDTO);
    }

    @GetMapping("/payment/{idPayment}")
    public ResponseEntity<PaymentDTO> getAppointmentById(@PathVariable("idPayment") Long idPayment) {
        PaymentDTO payments = paymentService.getPaymentById(idPayment);
        if (payments != null) {
            return ResponseEntity.ok(payments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/payment/add")
    public void addAppointment(@RequestBody Payment payment) {
        paymentService.save(payment);
    }


    @DeleteMapping("/payment/del/{idPayment}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("idPayment") Long idPayment) {
        paymentService.delete(idPayment);
        return ResponseEntity.noContent().build();
    }
}
