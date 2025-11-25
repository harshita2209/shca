package com.hms.User.entity;



import com.hms.User.constant.Roles;
import com.hms.User.dto.UserDTO;

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
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long id;
      private String name;
      @Column(unique=true)
      private String email;
      private String password;
      private Roles role;
      
      public UserDTO toDTO()
      {
     	 return new UserDTO(this.id,this.name,this.email,this.password,this.role);
      }
}
 