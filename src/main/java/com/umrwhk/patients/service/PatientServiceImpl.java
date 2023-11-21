package com.umrwhk.patients.service;

import com.umrwhk.patients.dto.*;
import com.umrwhk.patients.jpa.entity.Patient;
import com.umrwhk.patients.jpa.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
@Service
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseData> postNewPatient(PatientData req) {
        Patient patient = patientRepository.save(new Patient(req));
        return ResponseEntity.ok(new ResponseData(new MetaData(HttpStatus.OK), new PatientData(patient)));
    }

    @Override
    public ResponseEntity<ResponseData> getPatientDetail(String pid) {
        Patient patient = patientRepository.findByPid(pid).orElse(null);
        if (patient == null){
            return ResponseEntity.badRequest()
                    .body(new ResponseData(new MetaData(HttpStatus.BAD_REQUEST), "Patient not found"));
        }
        return ResponseEntity.ok(new ResponseData(new MetaData(HttpStatus.OK),new PatientData(patient)));
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseData> putUpdatePatient(PatientData req) {
        Patient patient = patientRepository.findByPid(req.getPid()).orElse(null);
        if (patient == null){
            return ResponseEntity.badRequest()
                    .body(new ResponseData(new MetaData(HttpStatus.BAD_REQUEST), "Patient not found"));
        }

        patient.update(req);
        patientRepository.save(patient);
        return ResponseEntity.ok(new ResponseData(new MetaData(HttpStatus.OK),new PatientData(patient)));
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseData> deletePatient(String pid) {
        Patient patient = patientRepository.findByPid(pid).orElse(null);
        if (patient == null){
            return ResponseEntity.badRequest()
                    .body(new ResponseData(new MetaData(HttpStatus.BAD_REQUEST), "Patient not found"));
        }

        patientRepository.delete(patient);
        return ResponseEntity.ok(new ResponseData(new MetaData(HttpStatus.OK), "Patient deleted"));
    }

    @Override
    public ResponseEntity<PageableResponse> getPatientPage(Pageable pageable, String q) {
        q = q != null ? q : "";
        Page<Patient> patientPage = patientRepository.findAllByPidContainingOrFirstNameContainingOrLastNameContaining(pageable, q, q, q);
        List<PatientData> respData = patientPage.getContent().stream().map(PatientData::new).collect(Collectors.toList());
        PageableResponse response = new PageableResponse(new PageData(patientPage), respData);
        return ResponseEntity.ok(response);
    }
}
