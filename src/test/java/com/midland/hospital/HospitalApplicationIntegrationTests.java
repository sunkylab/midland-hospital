package com.midland.hospital;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.midland.hospital.modules.patient.dto.PatientFilterDTO;
import com.midland.hospital.modules.patient.service.PatientService;
import com.midland.hospital.modules.staff.dto.StaffProfileDTO;
import com.midland.hospital.modules.staff.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HospitalApplicationIntegrationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	StaffService staffService;

	@Autowired
	PatientService patientService;

	@Test
	public void givenStaffIsCreated_thenStatus200()
			throws Exception {

		StaffProfileDTO profileDTO = new StaffProfileDTO();
		profileDTO.setName("Tim Labi");

		staffService.createStaffRecord(profileDTO);

		mvc.perform(MockMvcRequestBuilders.get("/api/v1/staffs")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.code").value("00"))
				.andExpect(jsonPath("$.data").isNotEmpty());
	}

	@Test
	public void givenPatientIsFetched_thenStatus200()
			throws Exception {

		PatientFilterDTO filterDTO = new PatientFilterDTO(2);
		ObjectMapper objectMapper = new ObjectMapper();

		mvc.perform(MockMvcRequestBuilders.post("/api/v1/patients?page=0&size=5")
				.contentType(MediaType.APPLICATION_JSON).header("uuid","invalid-uuid").content(objectMapper.writeValueAsString(filterDTO)))
				.andExpect(status().isForbidden())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

}
