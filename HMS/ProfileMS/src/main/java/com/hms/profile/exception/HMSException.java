package com.hms.profile.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HMSException extends Exception {
	private static final long serialVersionUID=1L;
	 private final String errorCode;
     private final String errorMessage;
     private final HttpStatus httpStatus;



     public HMSException(String errorCode,String errorMessage,HttpStatus httpStatus)
     {
  	   super(errorMessage);
  	   this.errorCode=errorCode;
  	   this.errorMessage=errorMessage;
  	   this.httpStatus=httpStatus; 
     }

}
