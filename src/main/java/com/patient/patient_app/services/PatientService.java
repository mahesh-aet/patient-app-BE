package com.patient.patient_app.services;

import com.patient.patient_app.dto.PatientDto;
import com.patient.patient_app.model.Patient;
import com.patient.patient_app.repo.PatientRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public PatientDto createPatient(PatientDto patientDto){

        patientRepo.save(modelMapper.map(patientDto,Patient.class));
        return patientDto;
    }
    public PatientDto updatePatient(PatientDto patientDto){
        patientRepo.save(modelMapper.map(patientDto,Patient.class));
        return patientDto;
    }
    public String deletePatient(Integer patientId){
        patientRepo.deleteById(patientId);
        return "deleted successfully";
    }

}
