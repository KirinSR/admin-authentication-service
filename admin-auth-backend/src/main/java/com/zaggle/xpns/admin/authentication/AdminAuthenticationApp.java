package com.zaggle.xpns.admin.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@BatchDataSource
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@EnableAutoConfiguration()
@EnableWebSecurity
public class AdminAuthenticationApp {
	public static void main(String[] args) {
		SpringApplication.run(AdminAuthenticationApp.class, args);
	}
}