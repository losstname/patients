package com.umrwhk.patients.service;

import com.umrwhk.patients.dto.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
public interface PatientService {
    ResponseEntity<ResponseData> postNewPatient(PatientData req);
    ResponseEntity<ResponseData> getPatientDetail(String pid);
    ResponseEntity<ResponseData> putUpdatePatient(PatientData req);
    ResponseEntity<ResponseData> deletePatient(String pid);

    ResponseEntity<PageableResponse> getPatientPage(Pageable pageable, String q);
}
