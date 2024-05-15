package com.example.graduateWork.dto;

import com.example.graduateWork.entity.SpecificationDic;
import lombok.Data;

@Data
public class DoctorDTO {
    private String nameDoc;
    private String lastnameDoc;
    private String patronymicDoc;
    private int experience;
    private SpecificationDic specificationDic;

    public DoctorDTO(String nameDoc, String lastnameDoc, String patronymicDoc
            , int experience, SpecificationDic specificationDic){
        this.nameDoc = nameDoc;
        this.lastnameDoc = lastnameDoc;
        this.patronymicDoc = patronymicDoc;
        this.experience = experience;
        this.specificationDic = specificationDic;
    }
}
