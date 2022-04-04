package com.midland.hospital.modules.staff.service;

import com.midland.hospital.modules.staff.dto.StaffProfileDTO;

import java.util.List;

public interface StaffService {

    String createStaffRecord(StaffProfileDTO profileDTO);

    void updateStaffRecord(StaffProfileDTO profileDTO, String profileUUID);

    StaffProfileDTO getStaffRecord(String profileUUID);

    List<StaffProfileDTO> getAllStaffs();

}
