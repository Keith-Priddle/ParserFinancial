package com.moderncloudtech.financial.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moderncloudtech.financial.accounts.AccountHolder;
import com.moderncloudtech.financial.services.AccountHolderServices;



@RestController
public class AccountHolderController {

	
	private AccountHolderServices accountHolderServices;
	
	
	public AccountHolderController(AccountHolderServices accountHolderServices) {
		super();
		this.accountHolderServices = accountHolderServices;
	}
	
	@RequestMapping(path="/AccountHolder", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<AccountHolder>> getAccountHolders(){
		System.out.println("Hitting Account Holder Controller---------------->");
		List<AccountHolder> accountHolders = accountHolderServices.getAccountHolders();
		return new ResponseEntity<List<AccountHolder>>(accountHolders, HttpStatus.OK);
	}
	
	
	@RequestMapping(path="/AccountHolder", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity <AccountHolder> createAccountHolder(AccountHolder accountHolder){
		accountHolderServices.createAccountHolder(accountHolder);
		return new ResponseEntity<AccountHolder>(accountHolder, HttpStatus.OK);
	}
	
	
}

