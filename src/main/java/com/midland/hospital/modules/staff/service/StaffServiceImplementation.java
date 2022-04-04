package com.midland.hospital.modules.staff.service;

import com.midland.hospital.core.exceptions.AppBaseException;
import com.midland.hospital.modules.staff.dto.StaffProfileDTO;
import com.midland.hospital.modules.staff.entities.Staff;
import com.midland.hospital.modules.staff.entities.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImplementation implements StaffService{

    @Autowired
    StaffRepository staffRepository;

    @Override
    public String createStaffRecord(StaffProfileDTO profileDTO) {

        Staff staff = staffRepository.findByName(profileDTO.getName());
        if(staff !=null){
            throw new AppBaseException("Record Already Exists");
        }

        staff = new Staff(profileDTO);
        staff = staffRepository.save(staff);
        return staff.getUuid();
    }

    @Override
    public void updateStaffRecord(StaffProfileDTO profileDTO, String profileUUID) {

        Staff staff = staffRepository.findByUuid(profileUUID);
        if(staff == null){
            throw new AppBaseException("Record Not Found");
        }

        staff.setName(profileDTO.getName());
        staffRepository.save(staff);

    }

    @Override
    public StaffProfileDTO getStaffRecord(String profileUUID) {
        StaffProfileDTO profileDTO =  staffRepository.findStaffProfileByUuid(profileUUID);
        return profileDTO;
    }

    @Override
    public List<StaffProfileDTO> getAllStaffs() {
        return staffRepository.findAllStaffs();
    }
}
