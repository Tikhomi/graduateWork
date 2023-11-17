package com.example.graduateWork.dto;

import lombok.Data;

@Data
public class UsersDTO {
    private Long id_user;
    private int phoneNumber;

    public UsersDTO(Long id_user, int phoneNumber) {
        this.id_user = id_user;
        this.phoneNumber = phoneNumber;
    }
}