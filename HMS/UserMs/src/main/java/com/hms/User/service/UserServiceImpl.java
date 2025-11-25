package com.hms.User.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hms.User.constant.ErrorInfo;
import com.hms.User.dto.UserDTO;
import com.hms.User.entity.User;
import com.hms.User.exception.HMSException;
import com.hms.User.repositoryDao.UserRepository;

import lombok.RequiredArgsConstructor;

@Service("iserService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private  final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
//	public final UserEntity userEntity;
	@Override
	public void registerUser(UserDTO userDTO) throws HMSException
	{
		Optional<User> opt=userRepository.findByEmail(userDTO.getEmail());
		if(opt.isPresent())
		{
			throw new HMSException(ErrorInfo.USER_ALREADY_EXISTS.getErrorCode(),ErrorInfo.USER_ALREADY_EXISTS.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		userRepository.save(userDTO.toEntity());
	}
	
	@Override
	public UserDTO loginUser(UserDTO userDTO) throws HMSException
	{
		User user=userRepository.findByEmail(userDTO.getEmail()).orElseThrow(()->new HMSException(ErrorInfo.USER_NOT_FOUND.getErrorCode(),ErrorInfo.USER_NOT_FOUND.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR));
		if(!passwordEncoder.matches(userDTO.getPassword(), user.getPassword()))
		{
			throw new HMSException(ErrorInfo.INVALID_CREDENTIALS.getErrorCode(),ErrorInfo.INVALID_CREDENTIALS.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		user.setPassword(null);//remove password from response
		return user.toDTO();
		
		
	}
	
	@Override
	public UserDTO getUserById(Long id) throws HMSException
	{
		return userRepository.findById(id).orElseThrow(()->new HMSException(ErrorInfo.USER_NOT_FOUND.getErrorCode(),ErrorInfo.USER_NOT_FOUND.getErrorCode(),HttpStatus.INTERNAL_SERVER_ERROR)).toDTO();
	}
	
	@Override
	public void updateUser(UserDTO userDTO)
	{
		
	}

	@Override
	public UserDTO getUser(String email) throws HMSException{
		return userRepository.findByEmail(email).orElseThrow(() -> new HMSException(ErrorInfo.USER_NOT_FOUND.getErrorCode(), ErrorInfo.USER_NOT_FOUND.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR)).toDTO();
	}
	

}
