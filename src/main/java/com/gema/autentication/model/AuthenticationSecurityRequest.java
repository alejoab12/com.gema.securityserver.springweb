package com.gema.autentication.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AuthenticationSecurityRequest {
	@NotNull(message="Username null")
	@NotBlank(message = "Empty username")
	private String username;
	@NotNull(message = "Password null")
	@NotBlank(message="Empty password")
	private String password;
}
