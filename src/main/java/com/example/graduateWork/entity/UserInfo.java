package com.example.graduateWork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_info")
    private Long id_user_info;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "id_role")
    @JsonIgnore
    private Role role;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_specification")
    @JsonIgnore
    private SpecificationDic specificationDic;

}
