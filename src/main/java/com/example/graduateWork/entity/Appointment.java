package com.example.graduateWork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_appointment")
    private Long idAppointment;

    @Column(name = "dt_rec")
    private LocalDateTime dtRec;

    @Column(name = "dt_ap")
    private LocalDateTime dtAp;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "id_doctor")
    @JsonIgnore
    private Doctor userDoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "id_client")
    @JsonIgnore
    private Client userCl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status")
    @JsonIgnore
    private StatusDic status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    @JsonIgnore
    private Services service;

}