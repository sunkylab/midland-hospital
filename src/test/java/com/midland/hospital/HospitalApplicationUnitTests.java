package com.midland.hospital;

import com.midland.hospital.core.exceptions.AppBaseException;
import com.midland.hospital.modules.patient.dto.PatientFilterDTO;
import com.midland.hospital.modules.patient.dto.PatientProfileDTO;
import com.midland.hospital.modules.patient.service.PatientService;
import com.midland.hospital.modules.staff.dto.StaffProfileDTO;
import com.midland.hospital.modules.staff.service.StaffService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class HospitalApplicationUnitTests {

	@Autowired
	private StaffService staffService;

	@Autowired
	private PatientService patientService;


	@Test
	void shouldHaveUUIDGeneratedWhenStaffIsCreated() {

		//Given
		StaffProfileDTO profileDTO = new StaffProfileDTO();

		//When
		String uuid = staffService.createStaffRecord(profileDTO);

		//Then
		Assertions.assertNotNull(uuid);
		Assertions.assertTrue(uuid.length() == 36);
	}


	@Test
	void shouldReturnSuccessWhenValidUUIDisUsedForStaffUpdate() {
		//Given
		StaffProfileDTO profileDTO = new StaffProfileDTO();
		profileDTO.setName("James");

		//When
		String uuid = staffService.createStaffRecord(profileDTO);
		profileDTO.setName("Sam");
		staffService.updateStaffRecord(profileDTO,uuid);
		StaffProfileDTO updatedRecord = staffService.getStaffRecord(uuid);

		//Then
		Assertions.assertEquals(updatedRecord.getName(),profileDTO.getName());
	}

	@Test
	void shouldReturnFailureWhenInvalidUUIDisUsedForStaffUpdate() {

		//Given
		StaffProfileDTO profileDTO = new StaffProfileDTO();
		profileDTO.setName("James");

		//When
		staffService.createStaffRecord(profileDTO);

		//Then
		Assertions.assertThrows(AppBaseException.class,() -> staffService.updateStaffRecord(profileDTO,"uuid"));
		Assertions.assertThrowsExactly(AppBaseException.class,() -> staffService.updateStaffRecord(profileDTO,"uuid"),"Record Not Found");
	}


	@Test
	void shouldReturnAllPatientRecordsIfPatientsExist() {
		//Given
		PatientFilterDTO noFilter = null;

		//When
		List<PatientProfileDTO> dtoList = patientService.getPatients(noFilter,0,200);

		//Then
		Assertions.assertEquals(dtoList.size(),200);
	}

	@Test
	void shouldReturnPatientRecordsThatMatchFilterOnly() {
		//Given
		PatientFilterDTO ageFilter = new PatientFilterDTO(0);
		PatientFilterDTO dateRangeFilter = new PatientFilterDTO(new Date(),new Date());

		//When
		List<PatientProfileDTO> dtoList = patientService.getPatients(ageFilter,0,20);
		List<PatientProfileDTO> dtoList2 = patientService.getPatients(dateRangeFilter,0,10);

		//Then
		Assertions.assertEquals(dtoList.size(),20);
		Assertions.assertEquals(dtoList2.size(),10);
	}

	@Test
	void shouldOnlyUpdateDelFlagWhenPatientDeletionIsDone() {
		//Given
		PatientFilterDTO noFilter = null;

		//When
		patientService.removePatients(noFilter);
		List<PatientProfileDTO> dtoList = patientService.getPatients(noFilter,0,200);
		Long actualDataCount = patientService.getNumberOfRows();

		//Then
		Assertions.assertEquals(dtoList.size(),0);
		Assertions.assertEquals(actualDataCount,200);
	}

}
