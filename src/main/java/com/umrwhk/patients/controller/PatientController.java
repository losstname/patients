package com.umrwhk.patients.controller;

import com.umrwhk.patients.dto.*;
import com.umrwhk.patients.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by umrwhk(umrwhk@gmail.com)
 */
@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("")
    ResponseEntity<ResponseData> postNewPatientData(@RequestBody PatientData req){
        return patientService.postNewPatient(req);
    }

    @GetMapping("/detail/{pid}")
    ResponseEntity<ResponseData> getPatientDetail(@PathVariable String pid){
        return patientService.getPatientDetail(pid);
    }

    @PutMapping("")
    ResponseEntity<ResponseData> putUpdatePatient(@RequestBody PatientData req){
        return patientService.putUpdatePatient(req);
    }

    @DeleteMapping("/delete/{pid}")
    ResponseEntity<ResponseData> deletePatient(@PathVariable String pid){
        return patientService.deletePatient(pid);
    }

    @GetMapping("/page")
    ResponseEntity<PageableResponse> getPatientPage(Pageable pageable, @RequestParam(required = false) String q){
        return patientService.getPatientPage(pageable, q);
    }
}
