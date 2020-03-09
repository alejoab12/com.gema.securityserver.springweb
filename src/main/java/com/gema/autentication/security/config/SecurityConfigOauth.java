package com.gema.autentication.security.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "gema.oauth")
@Data
public class SecurityConfigOauth {
	private Map<String, ApplicationConfig> applicationConfig;
}
