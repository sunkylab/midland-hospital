package com.midland.hospital.modules.patient.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PatientCountDTO {

    private Long count;

    public PatientCountDTO(Long count) {
        this.count = count;
    }
}
