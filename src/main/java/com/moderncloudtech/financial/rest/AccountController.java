package com.moderncloudtech.financial.rest;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moderncloudtech.financial.accounts.Account;
import com.moderncloudtech.financial.services.AccountServices;

@RestController
public class AccountController {
 
	private AccountServices accountServices;
	
	public AccountController(AccountServices accountServices) {
		super();
		this.accountServices = accountServices;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(path="/Account", method=RequestMethod.POST,consumes="application/json", produces="application/json")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		 
		accountServices.createAccount(account);
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(path="/Account", method=RequestMethod.GET,consumes="application/json", produces="application/json")
	public ResponseEntity<List<Account>> getAllAccounts(){
		List<Account> accounts = accountServices.getAllAccounts();
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(path="/Account/{holderid}", method=RequestMethod.GET,consumes="application/json", produces="application/json")
	public ResponseEntity<List<Account>> getByAccountHolder(@PathVariable Long holderid){
		List<Account> accounts = this.accountServices.getByAccountHolder(holderid);
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(path="/Account/c/{currency}", method=RequestMethod.GET,consumes="application/json", produces="application/json")
	public ResponseEntity<List<Account>> getByCurrency(@PathVariable("currency") String currency){
		
		List<Account> accounts = accountServices.getAccountsByCurrency(currency);
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(path="/Account/list", method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Account>> getAccounts(){
		List<Account> accounts = accountServices.getAccounts();
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
		
	}
	
}
