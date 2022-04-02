package com.midland.hospital.modules.patient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PatientFilterDTO {

    private int age;
    private Date fromDate;
    private Date endDate;
}
