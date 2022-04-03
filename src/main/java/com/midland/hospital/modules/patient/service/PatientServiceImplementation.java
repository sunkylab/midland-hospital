package com.midland.hospital.modules.patient.service;

import com.midland.hospital.core.exceptions.AppBaseException;
import com.midland.hospital.modules.patient.dto.PatientFilterDTO;
import com.midland.hospital.modules.patient.dto.PatientProfileDTO;
import com.midland.hospital.modules.patient.entities.Patient;
import com.midland.hospital.modules.patient.entities.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImplementation implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void createPatientRecord(PatientProfileDTO profile) {

        Patient patient = this.getPatientRecord(profile.getName());
        if(patient != null){
            throw new AppBaseException("Record Already Exists");
        }

        patient = new Patient(profile);
        patientRepository.save(patient);

    }

    @Override
    public PatientProfileDTO getPatientProfile(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if(patient == null){
            throw new AppBaseException("Record Not Found");
        }
        PatientProfileDTO profileDTO = new PatientProfileDTO(patient);

        return profileDTO;
    }

    @Override
    public List<PatientProfileDTO> getPatients(PatientFilterDTO filterDTO) {
        return patientRepository.fetchPatients();
    }

    @Override
    public void removePatients(PatientFilterDTO filterDTO) {

    }

    @Override
    public Long getNumberOfRows() {
        //try to use count directly
        return patientRepository.getPatientCount().getCount();
    }


    private Patient getPatientRecord(String name){
        return patientRepository.findByName(name);
    }
}
