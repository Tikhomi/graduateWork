package com.example.graduateWork.dto;

import com.example.graduateWork.entity.Appointment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PaymentDTO {
    private Date dt_pay;
    private int costPay;
    private List<Appointment> appointment;

    public PaymentDTO(Date dt_pay, int costPay,List<Appointment> appointment){
        this.dt_pay = dt_pay;
        this.costPay = costPay;
        this.appointment = appointment;
    }
}
