package com.moderncloudtech.financial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;



@SpringBootApplication(scanBasePackages = {"com.moderncloudtech.financial"})
public class ParserFinancialApplication {
	@RequestMapping("/")
	public String Home() {
		
		return " Hello Docker World!!!!!";
	}

	
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/");
		SpringApplication.run(ParserFinancialApplication.class, args);
	}

	
	
	

}
