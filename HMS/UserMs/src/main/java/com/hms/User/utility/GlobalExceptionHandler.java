package com.hms.User.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hms.User.constant.ErrorInfo;
import com.hms.User.exception.HMSException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
          @ExceptionHandler(Exception.class)
          public ResponseEntity<ErrorResponse> exceptionHandler(Exception e)
          {
            ErrorResponse response=new ErrorResponse(ErrorInfo.GENERIC_ERROR.getErrorCode(),ErrorInfo.GENERIC_ERROR.getErrorMessage());
        	  return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
          }
          
          @ExceptionHandler(HMSException.class)
          public ResponseEntity<ErrorResponse> HMSExceptionHandler(HMSException e)
          {
        	  ErrorResponse error= new ErrorResponse(e.getErrorCode(),e.getErrorMessage());
        	  return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
          }

          @ExceptionHandler({MethodArgumentNotValidException.class,ConstraintViolationException.class})
          public ResponseEntity<ErrorResponse> handleValidationException(Exception e){
            String errorMsg;
            if(e instanceof MethodArgumentNotValidException manv){
              errorMsg=manv.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));

            }
            else{
              ConstraintViolationException cve=(ConstraintViolationException) e;
              errorMsg =cve.getConstraintViolations().stream().map(ConstraintViolation::getMessage ).collect(Collectors.joining(","));
            }
            ErrorInfo error=new ErrorInfo(errorMsg,HttpStatus.BAD_REQUEST.value());
          }

}
