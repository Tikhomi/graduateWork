package com.example.graduateWork.dto;

import com.example.graduateWork.entity.Users;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AppointmentDTO {
    private Date dt_rec;
    private Date dt_ap;
    private String description;
    private List<Users> users_doc;
    private List<Users> users_cl;

    public AppointmentDTO(Date dt_rec,Date dt_ap, String description, List<Users> users_doc, List<Users> users_cl){
        this.dt_rec = dt_rec;
        this.dt_ap = dt_ap;
        this.description = description;
        this.users_doc = users_doc;
        this.users_cl = users_cl;
    }
}
