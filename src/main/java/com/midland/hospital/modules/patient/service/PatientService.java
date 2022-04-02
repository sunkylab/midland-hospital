package com.midland.hospital.modules.patient.service;

import com.midland.hospital.modules.patient.dto.PatientFilterDTO;
import com.midland.hospital.modules.patient.dto.PatientProfileDTO;

import java.util.List;

public interface PatientService {

    void createPatientRecord(PatientProfileDTO profile);

    PatientProfileDTO getPatientProfile(Long patientId);

    List<PatientProfileDTO> getPatients(PatientFilterDTO filterDTO);

    void removePatients(PatientFilterDTO filterDTO);

}
