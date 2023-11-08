package com.example.graduateWork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long id_payment;

    @Column(name = "date_pay")
    @Temporal(TemporalType.DATE)
    private Date dt_pay;

    @Column(name = "cost_pay")
    private int costPay;

    @ManyToOne
    @JoinColumn(name = "id_appointment")
    @JsonIgnore
    private Appointment appointment;

}