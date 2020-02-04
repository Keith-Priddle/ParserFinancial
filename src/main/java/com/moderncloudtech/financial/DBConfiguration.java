package com.moderncloudtech.financial;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	
	@Profile("test")
	@Bean
	public String testDatabaseConnection() {
		System.out.println("Running in Test Profile using MYSQL +++++++++++++++++++");
		return "Running in test profile";
	}
	
	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		System.out.println("Running in Dev Profile using MYSQL +++++++++++++++++++");	
		return "Running in test profile";
	}
	
	
}
