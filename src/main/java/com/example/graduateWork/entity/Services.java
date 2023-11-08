package com.example.graduateWork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "services")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private Long id_service;

    @Column(name = "nm_service")
    private String nm_service;

    @Column(name = "cost_serv")
    private int costServ;

    @ManyToOne
    @JoinColumn(name = "id_appointment")
    @JsonIgnore
    private Appointment appointment;


}