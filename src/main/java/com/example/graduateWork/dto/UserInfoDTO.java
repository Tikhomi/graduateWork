package com.example.graduateWork.dto;

import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.entity.Role;
import com.example.graduateWork.entity.Users;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserInfoDTO {
    private String name;
    private String lastname;
    private String patronymic;
    private Date birthday;
    private List<Role> role;
    private List<Users> users;
    private List<Appointment> appointment;

    public UserInfoDTO(String name, String lastname, String patronymic,
                       Date birthday, List<Role> role, List<Users> users,
                       List<Appointment> appointment){
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.role = role;
        this.users = users;
        this.appointment = appointment;
    }
}
