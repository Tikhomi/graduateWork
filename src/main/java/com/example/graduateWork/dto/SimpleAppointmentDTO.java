package com.example.graduateWork.dto;

import java.util.Date;

public class SimpleAppointmentDTO {
    private Date dtAp;
    private String doctorName;
    private String serviceName;
    private String statusName;

    // Конструкторы, геттеры и сеттеры
    public SimpleAppointmentDTO(Date dtAp, String doctorName, String serviceName, String statusName) {
        this.dtAp = dtAp;
        this.doctorName = doctorName;
        this.serviceName = serviceName;
        this.statusName = statusName;
    }

    public Date getDtAp() {
        return dtAp;
    }

    public void setDtAp(Date dtAp) {
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
