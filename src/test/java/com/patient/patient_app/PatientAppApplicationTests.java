package com.patient.patient_app;

import com.patient.patient_app.dto.PatientDto;
import com.patient.patient_app.model.Patient;
import com.patient.patient_app.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PatientAppApplicationTests {

	@Autowired
	PatientService patientService;

	@Test
	void testCreatePatient(){
		PatientDto patientDto = new PatientDto();
		patientDto.setFirstName("mahesh");
		patientDto.setLastName("kul");
//		patientDto.setEmail("tesqt2@gmail.com");
//		patientDto.setPhoneNumber("3789");

		Patient createdPatient = patientService.createPatient(patientDto);
		assertNotNull(createdPatient.getId());
	}

}
