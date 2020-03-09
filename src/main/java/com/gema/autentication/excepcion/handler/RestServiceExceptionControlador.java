package com.gema.autentication.excepcion.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gema.autentication.excepcion.RestServiceException;
import com.gema.autentication.model.ResponseError;

@ControllerAdvice
public class RestServiceExceptionControlador {
	@ExceptionHandler(value = RestServiceException.class)
	public ResponseEntity<Object> exception(RestServiceException exception) {

		return ResponseEntity.status(exception.getCodeResponse().intValue())
				.body(new ResponseError(exception.getCodeResponse(), exception.getMessage()));
	}
}
