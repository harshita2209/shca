package com.hms.profile.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.profile.constant.ErrorInfo;
import com.hms.profile.dto.DoctorDTO;
import com.hms.profile.exception.HMSException;
import com.hms.profile.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

   

    @Autowired
    private final DoctorRepository doctorRepository;

    DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDTO getDoctorById(Long id) throws HMSException {
        return doctorRepository.findById(id).orElseThrow(() -> new HMSException(ErrorInfo.PATIENT_NOT_FOUND.getErrorCode(), "Doctor with ID " + id + " not found.", null)).toDTO();
    }

    @Override
    public Long addDoctor(DoctorDTO doctorDTO) throws HMSException {
        if(doctorDTO.getEmail() != null && doctorRepository.findByEmail(doctorDTO.getEmail()).isPresent()) {
            throw new HMSException(ErrorInfo.PATIENT_ALREADY_EXISTS.getErrorCode() ,"Doctor with ID " + doctorDTO.getId() + " already exists.", null);
        }
        if(doctorDTO.getLicenseNo() !=null && doctorRepository.findByLicenseNo(doctorDTO.getLicenseNo()).isPresent()) {
            throw new HMSException(ErrorInfo.PATIENT_ALREADY_EXISTS.getErrorCode() ,"Doctor with ID " + doctorDTO.getId() + " already exists.", null);
        }
        return doctorRepository.save(doctorDTO.toEntity()).getId();
    }
    
}
