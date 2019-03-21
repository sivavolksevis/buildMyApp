package com.volksevis.b2bapp.exception;

import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.volksevis.b2bapp.Model.ErrorResponseEntity;

@ControllerAdvice
public class VolksevisExceptionHandler {

	@ExceptionHandler({ MemberNotFoundException.class, UnknownHostException.class })
	public ResponseEntity<ErrorResponseEntity> exceptionUserNotFoundHandler(Exception exception) {
		ErrorResponseEntity error = new ErrorResponseEntity();
		error.setSuccess(false);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setError(exception.getMessage());
		MultiValueMap<String, String> errorResponseMessage = new LinkedMultiValueMap<>();
		errorResponseMessage.add("errorMessage", exception.getMessage());
		return new ResponseEntity<ErrorResponseEntity>(error, errorResponseMessage, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ MemberProfileException.class, VolksevisException.class })
	public ResponseEntity<ErrorResponseEntity> exceptionMemberProfileHandler(Exception exception) {
		ErrorResponseEntity error = new ErrorResponseEntity();
		error.setSuccess(false);
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setError(exception.getMessage());
		MultiValueMap<String, String> errorResponseMessage = new LinkedMultiValueMap<>();
		errorResponseMessage.add("errorMessage", exception.getMessage());
		return new ResponseEntity<ErrorResponseEntity>(error, errorResponseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}