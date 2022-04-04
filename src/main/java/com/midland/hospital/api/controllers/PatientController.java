package com.midland.hospital.api.controllers;

import com.midland.hospital.api.shared.APIResponse;
import com.midland.hospital.core.service.CSVService;
import com.midland.hospital.modules.patient.dto.PatientFilterDTO;
import com.midland.hospital.modules.patient.dto.PatientProfileDTO;
import com.midland.hospital.modules.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    CSVService csvService;

    @PostMapping(value = "")
    public ResponseEntity<APIResponse> fetchAllPatients(@Valid @RequestBody PatientFilterDTO filterDTO,
                                                        @RequestParam("page") String page,
                                                        @RequestParam("size") String size){
        int recordPage = page == null || page == "" ? 0: Integer.parseInt(page);
        int recordSize = size == null || size == "" ? 0: Integer.parseInt(size);
        List<PatientProfileDTO> patients = patientService.getPatients(filterDTO,recordPage,recordSize);

        return new ResponseEntity<>(new APIResponse(patients), HttpStatus.OK);
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadPatientProfile(
            @PathVariable("id") String id) {

        final PatientProfileDTO profileDTO = patientService.getPatientProfile(Long.valueOf(id));
        String fileName = String.format("attachment; filename=patient-%s-profile.csv",id);
        final InputStreamResource resource = new InputStreamResource(csvService.writeDataToCsv(profileDTO));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, fileName)
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
    }

    @DeleteMapping(value = "")
    public ResponseEntity<APIResponse> deletePatients(@Valid @RequestBody PatientFilterDTO filterDTO){
        Long countOfRecordsRemoved = patientService.removePatients(filterDTO);
        String message = String.format("Successfully Deleted  %s Records",countOfRecordsRemoved);

        return new ResponseEntity<>(new APIResponse(message), HttpStatus.OK);

    }
}
