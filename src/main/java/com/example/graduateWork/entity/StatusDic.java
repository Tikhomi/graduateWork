package com.example.graduateWork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "status_dic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long id_status;

    @Column(name = "nm_status")
    private String nm_status;

}