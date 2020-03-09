package com.gema.autentication.security.config;

import lombok.Data;

@Data
public class ApplicationConfig {
	private String name;
	private String password;
	private String jwtPassword;
	private Integer timeExpiration;
}
