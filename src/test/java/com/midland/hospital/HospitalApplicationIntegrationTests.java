package com.midland.hospital;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-integrationtest.properties")
class HospitalApplicationIntegrationTests {

	@Autowired
	private MockMvc mvc;


//	@Test
//	public void givenEmployees_whenGetEmployees_thenStatus200()
//			throws Exception {
//
//		mvc.perform(get("/api/employees")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content()
//						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//				.andExpect(jsonPath("$[0].name", is("bob")));
//	}

}
