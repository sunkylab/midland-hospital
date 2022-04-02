package com.midland.hospital.modules.patient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientProfileDTO {

    private Long id;
    private String name;
    private int age;
    private Date lastVisitDate;

}
