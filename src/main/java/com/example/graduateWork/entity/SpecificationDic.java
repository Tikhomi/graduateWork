package com.example.graduateWork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "specification_dic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationDic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_specification")
    private Long id_specification;

    @Column(name = "nm_specification")
    private String nm_specification;

}