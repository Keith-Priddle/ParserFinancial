package com.moderncloudtech.financial;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.moderncloudtech.financial.services.AccountServices;

@Profile("test")
@Configuration
public class AccountServiceTestConfiguration {
	
	   //@Bean
	   //@Primary
	   //public AccountServices accountServices() {
	      //return Mockito.mock(AccountServices.class);
	   //}
	//test comment
}
