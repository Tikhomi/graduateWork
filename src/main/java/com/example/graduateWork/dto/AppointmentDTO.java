package com.example.graduateWork.dto;

import com.example.graduateWork.entity.Client;
import com.example.graduateWork.entity.Doctor;
import com.example.graduateWork.entity.Users;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AppointmentDTO {
    private Date dt_rec;
    private Date dt_ap;
    private String description;
    private Doctor user_doc;
    private Client user_cl;

    public AppointmentDTO(Date dt_rec,Date dt_ap, String description, Doctor user_doc, Client user_cl){
        this.dt_rec = dt_rec;
        this.dt_ap = dt_ap;
        this.description = description;
        this.user_doc = user_doc;
        this.user_cl = user_cl;
    }
}
