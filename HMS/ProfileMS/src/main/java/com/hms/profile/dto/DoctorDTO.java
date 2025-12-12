package com.hms.profile.dto;

import java.time.LocalDate;

import com.hms.profile.entity.Doctor;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
        private Long id;
      private String name;

      private String email;
      private LocalDate dob;
      private String phone;
      private String address;

      private String aadharNo;
      private BloodGroup bloodGroup;
      private String specialization;
      private String department;

      private String licenseNo;
      private Integer totalExp;

      public Doctor toEntity() {
            return new Doctor(id, name, email, dob, phone, address, aadharNo, bloodGroup, specialization, department, licenseNo, totalExp);
      } 
}
