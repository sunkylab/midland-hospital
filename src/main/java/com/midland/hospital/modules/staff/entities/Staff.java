package com.midland.hospital.modules.staff.entities;

import com.midland.hospital.core.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;

@Data
@Entity
@Where(clause = "del_flag='N'")
public class Staff extends AbstractEntity {

    private String name;
    private String uuid;

}
