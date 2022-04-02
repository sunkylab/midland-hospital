package com.midland.hospital.modules.staff.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StaffProfileDTO {

    private Long id;
    private String name;
    private String uuid;
    private Date registrationDate;
}
