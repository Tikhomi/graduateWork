package com.example.graduateWork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long idPayment;

    @Column(name = "date_pay")
    @Temporal(TemporalType.DATE)
    private Date dt_pay;

    @Column(name = "cost_pay")
    private int costPay;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAppointment")
    private List<Appointment> appointment;

}