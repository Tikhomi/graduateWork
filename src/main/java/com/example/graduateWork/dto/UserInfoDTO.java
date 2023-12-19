package com.example.graduateWork.dto;

import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.entity.Role;
import com.example.graduateWork.entity.SpecificationDic;
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
    private List<Users> users;
    private List<SpecificationDic> specificationDics;

    public UserInfoDTO(String name, String lastname, String patronymic,
                       Date birthday, List<Users> users,
                       List<SpecificationDic> specificationDics){
        this.name = name;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.users = users;
        this.specificationDics = specificationDics;
    }
}
