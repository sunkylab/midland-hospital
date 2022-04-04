package com.midland.hospital.modules.patient.entities;

import com.midland.hospital.core.AbstractEntity;
import com.midland.hospital.modules.patient.dto.PatientProfileDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
@Where(clause = "del_flag='N'")
public class Patient extends AbstractEntity {

    private String name;
    private int age;
    private Date lastVisitDate;

    public Patient() {
    }

    public Patient(PatientProfileDTO profileDTO) {
        this.name = profileDTO.getName();
        this.age = profileDTO.getAge();
        this.lastVisitDate = profileDTO.getLastVisitDate();
    }
}
