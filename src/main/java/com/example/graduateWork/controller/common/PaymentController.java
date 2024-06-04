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
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        List<PaymentDTO> paymentDTOs = paymentService.getAllPayments();
        return ResponseEntity.ok(paymentDTOs);
    }

    @GetMapping("/get/{idPayment}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable("idPayment") Long idPayment) {
        PaymentDTO paymentDTO = paymentService.getPaymentById(idPayment);
        if (paymentDTO != null) {
            return ResponseEntity.ok(paymentDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO) {
        PaymentDTO savedPaymentDTO = paymentService.save(paymentDTO);
        return ResponseEntity.ok(savedPaymentDTO);
    }

    @DeleteMapping("/del/{idPayment}")
    public ResponseEntity<Void> deletePayment(@PathVariable("idPayment") Long idPayment) {
        paymentService.delete(idPayment);
        return ResponseEntity.noContent().build();
    }
}
