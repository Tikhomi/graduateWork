package com.example.graduateWork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Long id_appointment;

    @Column(name = "dt_rec")
    private Date dt_rec;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_client")
    @JsonIgnore
    private Users users_cl;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    @JsonIgnore
    private Users users_doc;

    @ManyToOne
    @JoinColumn(name = "id_status")
    @JsonIgnore
    private StatusDic statusDic;
}