package com.midland.hospital.modules.staff.service;

import com.midland.hospital.modules.staff.dto.StaffProfileDTO;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImplementation implements StaffService{
    @Override
    public String createStaffRecord(StaffProfileDTO profileDTO) {
        return null;
    }

    @Override
    public void updateStaffRecord(StaffProfileDTO profileDTO, String profileUUID) {

    }

    @Override
    public StaffProfileDTO getStaffRecord(String profileUUID) {
        return null;
    }
}
