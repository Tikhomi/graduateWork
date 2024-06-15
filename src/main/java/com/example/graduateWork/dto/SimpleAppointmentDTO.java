package com.example.graduateWork.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class SimpleAppointmentDTO {
    private LocalDateTime dtAp;
    private String doctorName;
    private String serviceName;
    private String statusName;

    // Конструкторы, геттеры и сеттеры
    public SimpleAppointmentDTO(LocalDateTime dtAp, String doctorName, String serviceName, String statusName) {
        this.dtAp = dtAp;
        this.doctorName = doctorName;
        this.serviceName = serviceName;
        this.statusName = statusName;
    }

    public LocalDateTime getDtAp() {
        return dtAp;
    }

    public void setDtAp(LocalDateTime dtAp) {
        this.dtAp = dtAp;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
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
