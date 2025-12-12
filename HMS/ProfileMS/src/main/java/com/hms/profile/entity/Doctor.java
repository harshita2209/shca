package com.hms.profile.entity;

import java.time.LocalDate;

import com.hms.profile.dto.BloodGroup;
import com.hms.profile.dto.DoctorDTO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long id;
      private String name;
      @Column(unique=true)
      private String email;
      private LocalDate dob;
      private String phone;
      private String address;
      @Column(unique=true)
      private String aadharNo;
      private BloodGroup bloodGroup;
      private String specialization;
      private String department;
      @Column(unique=true)
      private String licenseNo;
      private Integer totalExp;

      
     
      public DoctorDTO toDTO(){
            return new DoctorDTO(id, name, email, dob, phone, address, aadharNo, bloodGroup, specialization, department, licenseNo, totalExp);
      }

}
