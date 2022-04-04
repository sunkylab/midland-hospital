package com.midland.hospital.modules.staff.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
public class StaffProfileDTO {

    private Long id;
    @NotEmpty
    private String name;
    private String uuid;
    private Date registrationDate;

    public StaffProfileDTO(Long id, String name, String uuid, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
        this.registrationDate = registrationDate;
    }

    public StaffProfileDTO() {

    }
}
