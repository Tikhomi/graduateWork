package com.example.graduateWork.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DoctorAppointmentDTO {
    private LocalDateTime  dtAp;
    private String clientName;
    private String serviceName;
    private String statusName;

    // Конструкторы, геттеры и сеттеры
    public DoctorAppointmentDTO(LocalDateTime dtAp, String clientName, String serviceName, String statusName) {
        this.dtAp = dtAp;
        this.clientName = clientName;
        this.serviceName = serviceName;
        this.statusName = statusName;
    }

    public LocalDateTime getDtAp() {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return dtAp;
    }

    public void setDtAp(LocalDateTime dtAp) {
        this.dtAp = dtAp;
    }

    public String getClientName() {
        return clientName;
    }

    public void clientName(String clientName) {
        this.clientName = clientName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }


}
