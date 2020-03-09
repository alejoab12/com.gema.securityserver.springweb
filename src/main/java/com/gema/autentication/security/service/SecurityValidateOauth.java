package com.gema.autentication.security.service;

import com.gema.autentication.security.config.ApplicationConfig;

public interface SecurityValidateOauth {
	public ApplicationConfig isValidOauth(String oauth);
}
