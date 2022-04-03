package com.midland.hospital.modules.patient.service;

import com.midland.hospital.modules.patient.dto.PatientFilterDTO;
import com.midland.hospital.modules.patient.dto.PatientProfileDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImplementation implements PatientService{

    @Override
    public void createPatientRecord(PatientProfileDTO profile) {

    }

    @Override
    public PatientProfileDTO getPatientProfile(Long patientId) {
        return null;
    }

    @Override
    public List<PatientProfileDTO> getPatients(PatientFilterDTO filterDTO) {
        return null;
    }

    @Override
    public void removePatients(PatientFilterDTO filterDTO) {

    }

    @Override
    public Long getNumberOfRows() {
        return null;
    }
}
