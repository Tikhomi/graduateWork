package com.example.graduateWork.dto;

import lombok.Data;

@Data
public class UsersDTO {

    private Long id_user;
    private Long phoneNumber;

    public UsersDTO(Long id_user, Long phoneNumber) {
        this.id_user = id_user;
        this.phoneNumber = phoneNumber;
    }
}