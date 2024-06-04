package com.example.graduateWork.dto;

import com.example.graduateWork.entity.Client;
import com.example.graduateWork.entity.Doctor;
import com.example.graduateWork.entity.StatusDic;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.Date;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAppointment")
public class AppointmentDTO {
    private Long idAppointment;
    private Date dt_rec;
    private Date dt_ap;
    private String description;
    private Doctor user_doc;
    private Client user_cl;
    private StatusDic status;


    public AppointmentDTO(Long idAppointment,Date dt_rec, Date dt_ap, String description, Doctor user_doc, Client user_cl, StatusDic status) {
        this.idAppointment = idAppointment;
        this.dt_rec = dt_rec;
        this.dt_ap = dt_ap;
        this.description = description;
        this.user_doc = user_doc;
        this.user_cl = user_cl;
        this.status = status;
    }
}
