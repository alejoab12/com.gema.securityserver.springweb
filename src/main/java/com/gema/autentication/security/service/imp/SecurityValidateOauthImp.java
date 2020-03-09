package com.gema.autentication.security.service.imp;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gema.autentication.security.config.ApplicationConfig;
import com.gema.autentication.security.config.SecurityConfigOauth;
import com.gema.autentication.security.service.SecurityValidateOauth;

@Service
public class SecurityValidateOauthImp implements SecurityValidateOauth {
	@Autowired
	private SecurityConfigOauth securityConfig;

	@Override
	public ApplicationConfig isValidOauth(String oauth) {
		ApplicationConfig applicationConfig = null;
		if (oauth.toUpperCase().contains("BASIC")) {
			String aux[] = oauth.split(" ");
			String oauthAux = new String(Base64.getDecoder().decode(aux[1]));
			String aux2[] = oauthAux.split("\\:");

			if (securityConfig.getApplicationConfig().containsKey(aux2[0])) {
				ApplicationConfig app = securityConfig.getApplicationConfig().get(aux2[0]);
				if (app.getPassword().equals(aux2[1])) {
					applicationConfig = app;
				}
			}
		}
		return applicationConfig;
	}

}
