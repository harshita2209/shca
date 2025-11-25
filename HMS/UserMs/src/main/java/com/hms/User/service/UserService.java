package com.hms.User.service;

import com.hms.User.dto.UserDTO;
import com.hms.User.exception.HMSException;



public interface UserService {
     public void registerUser(UserDTO userDTO) throws HMSException;
     public UserDTO loginUser(UserDTO userDTO) throws HMSException;
     public UserDTO getUserById(Long id) throws HMSException;
     public void updateUser(UserDTO userDTO);
     public UserDTO getUser(String email) throws HMSException;
}
