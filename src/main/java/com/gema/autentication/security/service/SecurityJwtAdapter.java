package com.gema.autentication.security.service;

import com.gema.autentication.model.AuthenticationSecurityRequest;
import com.gema.autentication.model.AuthenticationSecurityResponse;
import com.gema.autentication.security.config.ApplicationConfig;

public interface SecurityJwtAdapter {
	public AuthenticationSecurityResponse generateSecurity(AuthenticationSecurityRequest authenticationSecurityrequest,
			ApplicationConfig applicationConfig);
}
