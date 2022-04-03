package com.midland.hospital.modules.patient.entities.repository;

import com.midland.hospital.modules.patient.dto.PatientCountDTO;
import com.midland.hospital.modules.patient.entities.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query(value = "select new com.midland.hospital.modules.patient.dto.PatientCountDTO(count(p.id)) from Patient p group by p.id",nativeQuery = false)
    PatientCountDTO getPatientCount();

}
