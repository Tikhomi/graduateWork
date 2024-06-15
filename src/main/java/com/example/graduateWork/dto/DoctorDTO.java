package com.example.graduateWork.dto;

import com.example.graduateWork.entity.SpecificationDic;
import lombok.Data;

import java.util.Date;

@Data
public class DoctorDTO {
    private Long idDoctor;
    private String nameDoc;
    private String lastnameDoc;
    private String patronymicDoc;
    private int experience;
    private SpecificationDic specificationDic;

    public DoctorDTO(Long idDoctor, String nameDoc, String lastnameDoc, String patronymicDoc
            , int experience, SpecificationDic specificationDic){
        this.idDoctor = idDoctor;
        this.nameDoc = nameDoc;
        this.lastnameDoc = lastnameDoc;
        this.patronymicDoc = patronymicDoc;
        this.experience = experience;
        this.specificationDic = specificationDic;
    }

}
