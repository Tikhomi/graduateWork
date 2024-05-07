package com.example.graduateWork.dto;

import com.example.graduateWork.entity.Services;
import com.example.graduateWork.entity.StatusDic;
import com.example.graduateWork.entity.UserInfo;
import com.example.graduateWork.entity.Users;
import lombok.Data;
import org.apache.catalina.Server;

import java.util.Date;
import java.util.List;

@Data
public class AppointmentDTO {
    private Date dt_rec;
    private Date dt_ap;
    private String description;
    private List<UserInfo> users_doc;
    private List<UserInfo> users_cl;
    private List<Services> services;
    private List<StatusDic> statusDics;

    public AppointmentDTO(Date dt_rec,Date dt_ap, String description, List<UserInfo> users_doc, List<UserInfo> users_cl, List<Services> services, List<StatusDic> statusDics){
        this.dt_rec = dt_rec;
        this.dt_ap = dt_ap;
        this.description = description;
        this.users_doc = users_doc;
        this.users_cl = users_cl;
        this.services = services;
        this.statusDics = statusDics;
    }
}
