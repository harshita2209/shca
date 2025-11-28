package com.hms.User.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hms.User.dto.UserDTO;
import com.hms.User.exception.HMSException;
import com.hms.User.service.UserService;

@Service
public class MyUserDetaiilsService implements UserDetailsService{

    @Autowired
    UserService userService;

    @Override 
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        try{
            UserDTO dto=userService.getUser(email);
            return new CustomUserDetail(dto.getId(),dto.getEmail(),dto.getEmail(),dto.getPassword(),dto.getRole(),dto.getName(),null);
        }
        catch(HMSException e){
            throw new UsernameNotFoundException(email);
        }
        
    }
    
}
