package com.umrwhk.patients;

import com.umrwhk.patients.dto.PageableResponse;
import com.umrwhk.patients.dto.PatientData;
import com.umrwhk.patients.dto.ResponseData;
import com.umrwhk.patients.enums.Gender;
import com.umrwhk.patients.jpa.entity.Patient;
import com.umrwhk.patients.jpa.repository.PatientRepository;
import com.umrwhk.patients.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void testPostNewPatient() {

        PatientData patientData = new PatientData();
        patientData.setFirstName("John");
        patientData.setLastName("Doe");
        patientData.setDateOfBirth("1990-05-15");
        patientData.setGender("Male");
        patientData.setAddress("42 Kangaroo Street");
        patientData.setSuburb("Sydney");
        patientData.setState("NSW");
        patientData.setPostCode("2000");
        patientData.setPhoneNumber("+61 2 9876 5432");

        ResponseEntity<ResponseData> responseEntity = patientService.postNewPatient(patientData);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(patientData.getFirstName(), ((PatientData) responseEntity.getBody().getData()).getFirstName());
        assertEquals(patientData.getLastName(), ((PatientData) responseEntity.getBody().getData()).getLastName());
        assertEquals(patientData.getDateOfBirth(), ((PatientData) responseEntity.getBody().getData()).getDateOfBirth());
        assertEquals(patientData.getGender().toUpperCase(), ((PatientData) responseEntity.getBody().getData()).getGender());
        assertEquals(patientData.getAddress(), ((PatientData) responseEntity.getBody().getData()).getAddress());
        assertEquals(patientData.getSuburb(), ((PatientData) responseEntity.getBody().getData()).getSuburb());
        assertEquals(patientData.getState(), ((PatientData) responseEntity.getBody().getData()).getState());
        assertEquals(patientData.getPostCode(), ((PatientData) responseEntity.getBody().getData()).getPostCode());
        assertEquals(patientData.getPhoneNumber(), ((PatientData) responseEntity.getBody().getData()).getPhoneNumber());
    }

    @Test
    void testGetPatientDetail() {
        String patientId = UUID.randomUUID().toString();
        Patient patient = new Patient();
        patient.setPid(patientId);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setDateOfBirth(LocalDate.of(1990, 12, 12));
        patient.setGender(Gender.MALE);
        patient.setAddress("42 Kangaroo Street");
        patient.setSuburb("Sydney");
        patient.setState("NSW");
        patient.setPostCode("2000");
        patient.setPhoneNumber("+61 2 9876 5432");
        patientRepository.save(patient);

        ResponseEntity<ResponseData> responseEntity = patientService.getPatientDetail(patientId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(patient.getFirstName(), ((PatientData) responseEntity.getBody().getData()).getFirstName());
        assertEquals(patient.getLastName(), ((PatientData) responseEntity.getBody().getData()).getLastName());
        assertEquals(patient.getDateOfBirth().toString(), ((PatientData) responseEntity.getBody().getData()).getDateOfBirth());
        assertEquals(patient.getGender().name(), ((PatientData) responseEntity.getBody().getData()).getGender());
        assertEquals(patient.getAddress(), ((PatientData) responseEntity.getBody().getData()).getAddress());
        assertEquals(patient.getSuburb(), ((PatientData) responseEntity.getBody().getData()).getSuburb());
        assertEquals(patient.getState(), ((PatientData) responseEntity.getBody().getData()).getState());
        assertEquals(patient.getPostCode(), ((PatientData) responseEntity.getBody().getData()).getPostCode());
        assertEquals(patient.getPhoneNumber(), ((PatientData) responseEntity.getBody().getData()).getPhoneNumber());
    }

    @Test
    void testPutUpdatePatient() {

        String patientId = UUID.randomUUID().toString();

        Patient patient = new Patient();
        patient.setPid(patientId);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setDateOfBirth(LocalDate.of(1990, 12, 12));
        patient.setGender(Gender.FEMALE);
        patient.setAddress("42 Kangaroo Street");
        patient.setSuburb("Sydney");
        patient.setState("NSW");
        patient.setPostCode("2000");
        patient.setPhoneNumber("+61 2 9876 5432");
        patientRepository.save(patient);

        PatientData patientData = new PatientData();
        patientData.setPid(patientId);
        patientData.setFirstName("Doe");
        patientData.setLastName("Jhon");
        patientData.setDateOfBirth("1990-05-15");
        patientData.setGender("Male");
        patientData.setAddress("42 Kangaroo Street");
        patientData.setSuburb("Sydney");
        patientData.setState("NSW");
        patientData.setPostCode("2000");
        patientData.setPhoneNumber("+61 2 9876 5432");
        ResponseEntity<ResponseData> responseEntity = patientService.putUpdatePatient(patientData);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(patientData.getFirstName(), ((PatientData) responseEntity.getBody().getData()).getFirstName());
        assertEquals(patientData.getLastName(), ((PatientData) responseEntity.getBody().getData()).getLastName());
        assertEquals(patientData.getDateOfBirth(), ((PatientData) responseEntity.getBody().getData()).getDateOfBirth());
        assertEquals(patientData.getGender().toUpperCase(), ((PatientData) responseEntity.getBody().getData()).getGender());
        assertEquals(patientData.getAddress(), ((PatientData) responseEntity.getBody().getData()).getAddress());
        assertEquals(patientData.getSuburb(), ((PatientData) responseEntity.getBody().getData()).getSuburb());
        assertEquals(patientData.getState(), ((PatientData) responseEntity.getBody().getData()).getState());
        assertEquals(patientData.getPostCode(), ((PatientData) responseEntity.getBody().getData()).getPostCode());
        assertEquals(patientData.getPhoneNumber(), ((PatientData) responseEntity.getBody().getData()).getPhoneNumber());
    }

    @Test
    void testDeletePatient() {

        String patientId = UUID.randomUUID().toString();
        Patient patient = new Patient();
        patient.setPid(patientId);
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setDateOfBirth(LocalDate.of(1990, 12, 12));
        patient.setGender(Gender.MALE);
        patient.setAddress("42 Kangaroo Street");
        patient.setSuburb("Sydney");
        patient.setState("NSW");
        patient.setPostCode("2000");
        patient.setPhoneNumber("+61 2 9876 5432");
        patientRepository.saveAndFlush(patient);

        ResponseEntity<ResponseData> responseEntity = patientService.deletePatient(patientId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("Patient deleted", (String)responseEntity.getBody().getData());
    }
}
