package com.hms.User.dto;
import com.hms.User.constant.Roles;
import com.hms.User.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
	
      private Long id;
      @NotBlank(message="Name is mandatory")
      private String name;
      @NotBlank(message="Email is mandatory")
      @Email(message="Email should valid")
      private String email;
      @NotBlank(message="password is mandatory")
      @Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[\\W]).+{8,15}$", message="Password should contain atleast 1 uppercase, 1 lowercase, 1 digit and 1 special character min 8 char and max 15 character")
      
      private String password;
      private Roles role;
      private Long profileId;

     public User toEntity()
     {
    	 return new User(this.id,this.name,this.email,this.password,this.role,this.profileId);
     }
}
