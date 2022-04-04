package com.midland.hospital.api.controllers;

import com.midland.hospital.api.shared.APIResponse;
import com.midland.hospital.modules.staff.dto.StaffProfileDTO;
import com.midland.hospital.modules.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/staffs")
public class StaffController {

    @Autowired
    StaffService staffService;

    @PostMapping(value = "/create")
    public ResponseEntity<APIResponse> createStaff(@Valid @RequestBody StaffProfileDTO profileDTO){
        String uuid = staffService.createStaffRecord(profileDTO);
        return new ResponseEntity<>(new APIResponse(uuid), HttpStatus.OK);
    }

    @PostMapping(value = "/{uuid}/update")
    public ResponseEntity<APIResponse> updateStaff(@Valid @RequestBody StaffProfileDTO profileDTO, @PathVariable("uuid") String uuid){

        staffService.updateStaffRecord(profileDTO,uuid);
        return new ResponseEntity<>(new APIResponse(null), HttpStatus.OK);

    }

    @GetMapping(value = "")
    public ResponseEntity<APIResponse> fetchStaffs(){
        return new ResponseEntity<>(new APIResponse(staffService.getAllStaffs()), HttpStatus.OK);
    }
}
