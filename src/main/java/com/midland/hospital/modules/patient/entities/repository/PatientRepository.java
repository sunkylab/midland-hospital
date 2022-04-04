package com.midland.hospital.modules.patient.entities.repository;

import com.midland.hospital.modules.patient.dto.PatientCountDTO;
import com.midland.hospital.modules.patient.dto.PatientProfileDTO;
import com.midland.hospital.modules.patient.entities.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query(value = "select count(0) as cnt from patient p",nativeQuery = true)
    List<Object[]> getPatientCount();

    Patient findByName(String name);

    @Query(value = "select new com.midland.hospital.modules.patient.dto.PatientProfileDTO(p.id,p.name,p.age,p.lastVisitDate) from Patient p where p.age > :age order by p.id desc")
    List<PatientProfileDTO> fetchPatientsWhereAgeIsGreaterThan(Integer age, Pageable pageable);

    @Query(value = "select new com.midland.hospital.modules.patient.dto.PatientProfileDTO(p.id,p.name,p.age,p.lastVisitDate) from Patient p  order by p.id desc")
    List<PatientProfileDTO> fetchAllPatients(Pageable pageable);

    List<Patient> findByLastVisitDateBetween(Date fromDate, Date endDAte);


}
