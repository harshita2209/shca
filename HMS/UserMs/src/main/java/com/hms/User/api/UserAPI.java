package com.hms.User.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.User.constant.ErrorInfo;
import com.hms.User.dto.LoginDto;
import com.hms.User.dto.ResponseDTO;
import com.hms.User.dto.UserDTO;
import com.hms.User.exception.HMSException;
import com.hms.User.jwt.JwtUtil;
import com.hms.User.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@Validated
@CrossOrigin
@RequiredArgsConstructor
public class UserAPI {
	@Autowired
	private final UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticatorManager;

	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid UserDTO userDTO) throws HMSException
	{
		userService.registerUser(userDTO);
		return new ResponseEntity<>(new ResponseDTO("Account created."),HttpStatus.CREATED);
	}
	
	@PostMapping("/login") 
	public ResponseEntity<String> loginUser(@RequestBody @Valid LoginDto loginDTO) throws HMSException
	{
		try{
			authenticatorManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
			);
		}
		catch(AuthenticationException e){
			throw new HMSException(ErrorInfo.INVALID_CREDENTIALS.getErrorCode(), ErrorInfo.INVALID_CREDENTIALS.getErrorMessage(), HttpStatus.BAD_REQUEST);
		}
		final UserDetails userDetails=userDetailsService.loadUserByUsername(loginDTO.getEmail());

		final String jwt=jwtUtil.genetateToken(userDetails);
		return new ResponseEntity<>(jwt, HttpStatus.OK);

	}


	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("Test",HttpStatus.OK);
	}

}
