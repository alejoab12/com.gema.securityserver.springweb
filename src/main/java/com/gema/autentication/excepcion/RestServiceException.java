package com.gema.autentication.excepcion;

import lombok.Getter;

@Getter
public class RestServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Integer codeResponse;
	public RestServiceException(Integer codeResponse,String message) {
		super(message);
		this.codeResponse=codeResponse;		
	}
}
