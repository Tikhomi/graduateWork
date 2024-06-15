package com.example.graduateWork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Long idDoctor;

    @Column(name = "name_doc")
    private String nameDoc;

    @Column(name = "lastname_doc")
    private String lastnameDoc;

    @Column(name = "patronymic_doc")
    private String patronymicDoc;

    @Column(name = "birthday_doc")
    private Date birthdayDoc;

    @Column(name = "experience")
    private int experience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_specification")
    private SpecificationDic specificationDics;

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNameDoc() {
        return nameDoc;
    }

    public void setNameDoc(String nameDoc) {
        this.nameDoc = nameDoc;
    }

    public String getLastnameDoc() {
        return lastnameDoc;
    }

    public void setLastnameDoc(String lastnameDoc) {
        this.lastnameDoc = lastnameDoc;
    }

    public String getPatronymicDoc() {
        return patronymicDoc;
    }

    public void setPatronymicDoc(String patronymicDoc) {
        this.patronymicDoc = patronymicDoc;
    }

    public Date getBirthdayDoc() {
        return birthdayDoc;
    }

    public void setBirthdayDoc(Date birthdayDoc) {
        this.birthdayDoc = birthdayDoc;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public SpecificationDic getSpecificationDics() {
        return specificationDics;
    }

    public void setSpecificationDics(SpecificationDic specificationDics) {
        this.specificationDics = specificationDics;
    }

    public String getSpecializationName() {
        return specificationDics != null ? specificationDics.getName() : null;
    }
}
