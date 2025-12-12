package com.hms.profile.service;

import com.hms.profile.dto.PatientDTO;
import com.hms.profile.exception.HMSException;

public interface PatientService {
    public PatientDTO getPatientById(Long id) throws HMSException;
    public Long addPatient(PatientDTO patientDTO) throws HMSException;
}
