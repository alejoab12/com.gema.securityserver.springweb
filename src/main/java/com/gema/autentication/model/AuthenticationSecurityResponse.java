package com.gema.autentication.model;

import java.util.Date;

import lombok.Data;

@Data
public class AuthenticationSecurityResponse {
	private String token;
	private Date creationTime;
}
