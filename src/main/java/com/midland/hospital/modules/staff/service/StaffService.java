package com.midland.hospital.modules.staff.service;

import com.midland.hospital.modules.staff.dto.StaffProfileDTO;

public interface StaffService {

    String createStaffRecord(StaffProfileDTO profileDTO);

    void updateStaffRecord(StaffProfileDTO profileDTO, String profileUUID);

    StaffProfileDTO getStaffRecord(String profileUUID);

}
