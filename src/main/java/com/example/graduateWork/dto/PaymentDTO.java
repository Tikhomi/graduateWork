package com.example.graduateWork.dto;

import com.example.graduateWork.entity.Appointment;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentDTO {
    private Date dt_pay;
    private int costPay;
    private Appointment appointment;

    public PaymentDTO(Date dt_pay, int costPay, Appointment appointment){
        this.dt_pay = dt_pay;
        this.costPay = costPay;
        this.appointment = appointment;
    }
}
