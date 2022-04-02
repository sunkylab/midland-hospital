package com.midland.hospital.modules.patient.entities.repository;

import com.midland.hospital.modules.patient.entities.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {


}
