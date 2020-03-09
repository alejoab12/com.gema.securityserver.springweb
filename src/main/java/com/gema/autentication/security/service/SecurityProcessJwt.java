package com.gema.autentication.security.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.gema.autentication.excepcion.RestServiceException;
import com.gema.autentication.model.AuthenticationSecurityRequest;
import com.gema.autentication.model.AuthenticationSecurityResponse;
import com.gema.autentication.security.config.ApplicationConfig;

public abstract class SecurityProcessJwt implements SecurityJwtAdapter {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	protected AuthenticationSecurityResponse buildAuthenticationSecurityResponse(
			AuthenticationSecurityRequest authenticationSecurityRequest, String password, List<String> roles,
			ApplicationConfig applicationConfig) {
		AuthenticationSecurityResponse authenticationSecurityResponse = null;
		if (passwordEncoder.matches(authenticationSecurityRequest.getPassword(), password)) {

			try {
				Algorithm algorithm = Algorithm.HMAC256(applicationConfig.getJwtPassword());
				String token = JWT.create().withIssuer(applicationConfig.getName()).withClaim("roles", roles)
						.withExpiresAt(new Date(System.currentTimeMillis() + applicationConfig.getTimeExpiration()))
						.sign(algorithm);
				authenticationSecurityResponse = new AuthenticationSecurityResponse();
				authenticationSecurityResponse.setCreationTime(new Date());
				authenticationSecurityResponse.setToken(token);
			} catch (JWTCreationException exception) {
				exception.printStackTrace();
			}
		} else {
			throw new RestServiceException(401, "not authorized to make requests");
		}
		return authenticationSecurityResponse;
	}
}
