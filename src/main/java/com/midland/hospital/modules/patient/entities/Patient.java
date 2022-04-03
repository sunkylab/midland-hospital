package com.midland.hospital.modules.patient.entities;

import com.midland.hospital.core.AbstractEntity;
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

}
