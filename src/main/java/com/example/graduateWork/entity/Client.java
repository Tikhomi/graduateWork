package com.example.graduateWork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idClient")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "name_cl")
    private String nameCl;

    @Column(name = "lastname_cl")
    private String lastnameCl;

    @Column(name = "patronymic_cl")
    private String patronymicCl;

    @Column(name = "birthday_cl")
    private Date birthdayCl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private Users users;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idDocidClienttor) {
        this.idClient = idClient;
    }

    public String getNameCl() {
        return nameCl;
    }

    public void setNameCl(String nameCl) {
        this.nameCl = nameCl;
    }

    public String getLastnameCl() {
        return lastnameCl;
    }

    public void setLastnameCl(String lastnameCl) {
        this.lastnameCl = lastnameCl;
    }

    public String getPatronymicCl() {
        return patronymicCl;
    }

    public void setPatronymicCl(String patronymicCl) {
        this.patronymicCl = patronymicCl;
    }

    public Date getBirthdayCl() {
        return birthdayCl;
    }

    public void setBirthdayCl(Date birthdayCl) {
        this.birthdayCl = birthdayCl;
    }



    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
