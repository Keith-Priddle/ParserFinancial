package com.moderncloudtech.financial.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.moderncloudtech.financial.accounts.AccountHolder;
import com.moderncloudtech.financial.repositories.AccountHolderRepository;

@Service
public class AccountHolderServices {

	
	@Autowired
	private AccountHolderRepository accountHolderRepository;
	
	public AccountHolderServices(AccountHolderRepository accountHolderRepository) {
		super();
		this.accountHolderRepository = accountHolderRepository;
	}
	
	public List<AccountHolder> getAccountHolders(){
		List<AccountHolder> accountHolders = new ArrayList<>();
		System.out.println("Hitting service ----------------->");
		this.accountHolderRepository.GetAllAH().forEach(accountHolders::add);
		return accountHolders;
	}
	
	public void createAccountHolder(AccountHolder accountHolder) {
		AccountHolder newAcc = new AccountHolder();
				newAcc.setHolderId(1L);
		this.accountHolderRepository.save(newAcc);
	}
	
}
