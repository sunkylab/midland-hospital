package com.midland.hospital.modules.patient.entities.repository;

import com.midland.hospital.modules.patient.dto.PatientCountDTO;
import com.midland.hospital.modules.patient.dto.PatientProfileDTO;
import com.midland.hospital.modules.patient.entities.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query(value = "select new com.midland.hospital.modules.patient.dto.PatientCountDTO(count(p.id)) from Patient p group by p.id")
    PatientCountDTO getPatientCount();

    Patient findByName(String name);

    @Query(value = "select new com.midland.hospital.modules.patient.dto.PatientProfileDTO(p.id,p.name,p.age,p.lastVisitDate) from Patient p order by p.id desc")
    List<PatientProfileDTO> fetchPatients();
}
