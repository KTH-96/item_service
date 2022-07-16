package com.app.itemservice.exception.handler;

import com.app.itemservice.exception.CustomException;
import com.app.itemservice.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {CustomException.class})
	protected ResponseEntity<ErrorResponse> customException(CustomException e) {
		return ErrorResponse.toResponseEntity(e.getErrorMessage());
	}
}
