package com.hms.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.profile.constant.ErrorInfo;
import com.hms.profile.dto.PatientDTO;
import com.hms.profile.exception.HMSException;
import com.hms.profile.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDTO getPatientById(Long id) throws HMSException {
        return patientRepository.findById(id).orElseThrow(() -> 
            new HMSException(ErrorInfo.PATIENT_NOT_FOUND.getErrorMessage(),
                             "Patient with ID " + id + " not found.",
                             null)).toDTO();
    }



    @Override
    public Long addPatient(PatientDTO patientDTO) throws HMSException {
        if(patientDTO.getEmail() !=null && patientRepository.findByEmail(patientDTO.getEmail()).isPresent()) {
            throw new HMSException(ErrorInfo.PATIENT_ALREADY_EXISTS.getErrorMessage(),
                                   "Patient with ID " + patientDTO.getId() + " already exists.",
                                   null);
        }
        if(patientDTO.getAadharNo() != null && patientRepository.findByAadharNo(patientDTO.getAadharNo()).isPresent()) {
            throw new HMSException(ErrorInfo.PATIENT_ALREADY_EXISTS.getErrorMessage(),
                                   "Patient with ID " + patientDTO.getId() + " already exists.",
                                   null);
        }
        return patientRepository.save(patientDTO.toEntity()).getId();
    }
    
}
