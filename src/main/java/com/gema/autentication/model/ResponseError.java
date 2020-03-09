package com.gema.autentication.model;

import lombok.Data;

@Data
public class ResponseError {
	private Integer status;
	private String message;

	public ResponseError() {
	}

	public ResponseError(Integer status, String message) {
		this.status = status;
		this.message = message;
	}

}
