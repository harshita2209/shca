package com.hms.User.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.User.dto.ResponseDTO;
import com.hms.User.dto.UserDTO;
import com.hms.User.exception.HMSException;
import com.hms.User.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@Validated
@CrossOrigin
@RequiredArgsConstructor
public class UserAPI {
	private final UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid UserDTO userDTO) throws HMSException
	{
		userService.registerUser(userDTO);
		return new ResponseEntity<>(new ResponseDTO("Account created."),HttpStatus.CREATED);
	}
	
	@PostMapping("/login") 
	public ResponseEntity<UserDTO> loginUser(@RequestBody @Valid UserDTO userDTO) throws HMSException
	{
		return new ResponseEntity<>(userService.loginUser(userDTO),HttpStatus.OK);
	}

}
