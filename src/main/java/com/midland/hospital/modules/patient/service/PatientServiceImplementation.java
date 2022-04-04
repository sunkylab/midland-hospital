package com.midland.hospital.modules.patient.service;

import com.midland.hospital.core.exceptions.AppBaseException;
import com.midland.hospital.modules.patient.dto.PatientFilterDTO;
import com.midland.hospital.modules.patient.dto.PatientProfileDTO;
import com.midland.hospital.modules.patient.entities.Patient;
import com.midland.hospital.modules.patient.entities.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImplementation implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void createPatientRecord(PatientProfileDTO profile) {

        Patient patient = patientRepository.findByName(profile.getName());
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
    public List<PatientProfileDTO> getPatients(PatientFilterDTO filterDTO,int page,int size) {
        if(filterDTO!=null && filterDTO.getAge() < 0 ){
            throw new AppBaseException("Age should be equal or greater than zero");
        }

        Pageable pageable = PageRequest.of(page,size);

        if(filterDTO == null){
            return patientRepository.fetchAllPatients(pageable);
        }else{
            return patientRepository.fetchPatientsWhereAgeIsGreaterThan(filterDTO.getAge(),pageable);
        }
    }

    @Override
    public Long removePatients(PatientFilterDTO filterDTO) {
        List<Patient> patients;
        if(filterDTO == null){
            patients = (List<Patient>) patientRepository.findAll();
        }else{
            patients = patientRepository.findByLastVisitDateBetween(filterDTO.getFromDate(),filterDTO.getEndDate());
        }

        patients = patients.parallelStream().map(patient -> {
            patient.setDelFlag("Y");
            patient.setDeletedOn(new Date());
            return patient;
        }).collect(Collectors.toList());

        patientRepository.saveAll(patients);

        return Long.valueOf(patients.size());

    }

    @Override
    public Long getNumberOfRows() {
        List<Object[]> result =  patientRepository.getPatientCount();
        BigInteger rowResult = (BigInteger) result.get(0)[0];
        Long count = Long.valueOf(rowResult.toString());

        return count;
    }

}
