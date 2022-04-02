package com.midland.hospital.modules.staff.service;

import com.midland.hospital.modules.staff.dto.StaffProfileDTO;

public interface StaffService {

    void createStaffRecord(StaffProfileDTO profileDTO);

    void updateStaffRecord(StaffProfileDTO profileDTO, Long profileId);

}
