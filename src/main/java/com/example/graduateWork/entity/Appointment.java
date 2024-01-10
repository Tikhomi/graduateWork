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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_user")
    private List<Users> users_doc;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_user")
    private List<Users> users_cl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_status")
    private List<StatusDic> status;
}