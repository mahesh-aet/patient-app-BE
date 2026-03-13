package com.patient.patient_app.controller;

import com.patient.patient_app.dto.PatientDto;
import com.patient.patient_app.model.Patient;
import com.patient.patient_app.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<PatientDto> getAllPatient(){
        return patientService.getAllPatients();
    }
    @PostMapping
    public Patient addPatient(@RequestBody PatientDto patientDto){
        return patientService.createPatient(patientDto);
    }
    @PutMapping("/{id}")
    public PatientDto updatePatient(@RequestBody PatientDto patientDto, @PathVariable Integer id){
        return patientService.updatePatient(patientDto,id);
    }
    @DeleteMapping("/{patientId}")
    public String deletePatient(@PathVariable Integer patientId){
        return patientService.deletePatient(patientId);
    }


}
