package com.patient.patient_app.services;

import com.patient.patient_app.dto.PatientDto;
import com.patient.patient_app.model.Patient;
import com.patient.patient_app.repo.PatientRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class PatientService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientRepo patientRepo;

    public List<PatientDto> getAllPatients(){
        List<Patient> patientList =  patientRepo.findAll();
        return modelMapper.map(patientList,new TypeToken<List<PatientDto>>(){}.getType());
    }

    public Patient createPatient(PatientDto patientDto){
        if(patientRepo.existsByPhoneNumber(patientDto.getPhoneNumber())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Phone Number already exists"
            );
        }
        if(patientRepo.existsByEmail(patientDto.getEmail())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Email already exists"
            );
        }
        if( patientDto.getEmail() == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Email is required"
            );
        }
        if( patientDto.getPhoneNumber() == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "PhoneNumber is required"
            );
        }
        Patient patient = modelMapper.map(patientDto, Patient.class);
        return patientRepo.save(patient);
    }
    public PatientDto updatePatient(PatientDto patientDto, Integer id){
        patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Patient updatedpPatient = modelMapper.map(patientDto, Patient.class);
        patientRepo.save(updatedpPatient);
        return patientDto;
    }
    public String deletePatient(Integer patientId){
        patientRepo.deleteById(patientId);
        return "deleted successfully";
    }

}
