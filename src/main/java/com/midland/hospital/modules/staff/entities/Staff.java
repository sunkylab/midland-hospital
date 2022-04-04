package com.midland.hospital.modules.staff.entities;

import com.midland.hospital.core.AbstractEntity;
import com.midland.hospital.modules.staff.dto.StaffProfileDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Where(clause = "del_flag='N'")
public class Staff extends AbstractEntity {


    private String name;
    private String uuid;
    private Date registrationDate;

    public Staff(StaffProfileDTO profileDTO) {
        this.name = profileDTO.getName();
        this.uuid = String.valueOf(UUID.randomUUID());
        this.registrationDate = profileDTO.getRegistrationDate();
    }

    public Staff() {
    }
}
