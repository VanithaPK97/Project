package com.infosys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infosys.dto.ErrorMessage;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	@ExceptionHandler(NoSuchAccountException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(NoSuchAccountException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}
