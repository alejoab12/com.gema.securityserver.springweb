package com.gema.autentication.security.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.gema.autentication.excepcion.RestServiceException;
import com.gema.autentication.model.AuthenticationSecurityRequest;
import com.gema.autentication.model.AuthenticationSecurityResponse;
import com.gema.autentication.security.config.ApplicationConfig;
import com.gema.autentication.security.service.SecurityJwtAdapter;
import com.gema.autentication.security.service.SecurityValidateOauth;

@RestController
@RequestMapping("/oauth")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT}, origins = "*")
public class SecurityController {
	@Autowired
	private SecurityJwtAdapter securityJwtAdapter;
	@Autowired
	private SecurityValidateOauth securityValidateOauth;
	@PostMapping(path = "/token", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<AuthenticationSecurityResponse> genToken(
			@Valid @RequestBody AuthenticationSecurityRequest authenticationRequest,
			@RequestHeader("Authorization") String authorization, BindingResult result) {
		ApplicationConfig applicationConfig = securityValidateOauth.isValidOauth(authorization);
		if (result.hasErrors() && Objects.nonNull(authorization)) {
			throw new RestServiceException(400, "missing attributes");
		}
		if (Objects.isNull(applicationConfig)) {
			throw new RestServiceException(401, "not authorized to make requests");
		}
		return ResponseEntity.ok(securityJwtAdapter.generateSecurity(authenticationRequest, applicationConfig));

	}
}
