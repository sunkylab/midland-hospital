package com.midland.hospital.modules.patient.entities;

import com.midland.hospital.core.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
public class Patient extends AbstractEntity {

    private String name;
    private int age;
    private Date lastVisitDate;

}
