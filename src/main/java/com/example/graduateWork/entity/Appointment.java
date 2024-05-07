package com.example.graduateWork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private Date dtRec;

    @Column(name = "dt_ap")
    private Date dtAp;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_info")
    private List<UserInfo> users_doc;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_info")
    private List<UserInfo> users_cl;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_status")
    private List<StatusDic> status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_service")
    private List<Services> services;
}