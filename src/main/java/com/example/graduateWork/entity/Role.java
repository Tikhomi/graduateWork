package com.example.graduateWork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

public enum Role {
    ROLE_DOCTOR,
    ROLE_CLIENT,
    ROLE_ADMIN;
}
