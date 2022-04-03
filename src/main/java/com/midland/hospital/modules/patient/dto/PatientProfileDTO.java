package com.midland.hospital.modules.patient.dto;

import com.midland.hospital.modules.patient.entities.Patient;
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


    public PatientProfileDTO(Patient patient) {

        this.id = patient.getId();
        this.name = patient.getName();
        this.age = patient.getAge();
        this.lastVisitDate = patient.getLastVisitDate();
    }

    public PatientProfileDTO(Long id, String name, int age, Date lastVisitDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.lastVisitDate = lastVisitDate;
    }

    public PatientProfileDTO() {
    }
}
