package com.moderncloudtech.financial.accounts;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.bval.extras.constraints.checkdigit.IBAN;
import javax.persistence.Id;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	@Column(name="ACCOUNTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	
	@Column(name="TYPE")
	private String accountType;
	
	@Column(name="IBAN")
	@IBAN
	private String iban;
	
	@Column(name="BALANCE")
	private BigDecimal balance;
	
	@Column(name="CURRENCY")
	//@Type(type = "Currency")
	private String currency;
	
	@Column(name="OPENDATE")
	private LocalDate openDate;
	
	@Column(name="ACTIVE")
	private boolean active;
	
	public Account() {
		super();
	}

	public Account(Long accountId, String accountType, String iban, BigDecimal balance, String currency, LocalDate openDate, boolean active) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.iban = iban;
		this.balance = balance;
		this.currency = currency;
		this.openDate = openDate;
		this.active = active;
	}

	public Account(String accountType, String iban, BigDecimal balance, String currency, LocalDate openDate, boolean active) {
		super();
		this.accountType = accountType;
		this.iban = iban;
		this.balance = balance;
		this.currency = currency;
		this.openDate = openDate;
		this.active = active;
	}
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountId=");
		builder.append(accountId);
		builder.append(", iban=");
		builder.append(iban);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", openDate=");
		builder.append(openDate);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
