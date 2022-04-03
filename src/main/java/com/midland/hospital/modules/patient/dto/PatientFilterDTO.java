package com.midland.hospital.modules.patient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PatientFilterDTO {

    public PatientFilterDTO(int age) {
        this.age = age;
    }

    public PatientFilterDTO(Date fromDate, Date endDate) {
        this.fromDate = fromDate;
        this.endDate = endDate;
    }

    private int age;
    private Date fromDate;
    private Date endDate;
}
