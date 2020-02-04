package com.moderncloudtech.financial;

import java.io.IOException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication(scanBasePackages = {"com.moderncloudtech.financial"})
public class ParserFinancialApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/");
		SpringApplication.run(ParserFinancialApplication.class, args);
	}

	
	
	

}
