package com.moderncloudtech.financial.accounts;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ACCOUNTHOLDER")
public class AccountHolder {

	@Id
	@Column(name="HOLDERID")
	//GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long holderId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="BIRTHDATE")
	private Date birthDate;
	
	//@Column(name="ADDRESS")
	//private Address address;
	
	
	public AccountHolder() {};
	
	public AccountHolder(Long holderId, String email, String firstName, String lastName, String title, Date birthDate ) {
		super();
		this.holderId = holderId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.birthDate = birthDate;
		//this.address = address;
	}


	

	public Long getHolderId() {
		return holderId;
	}

	public void setHolderId(Long holderId) {
		this.holderId = holderId;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	@Override
	public String toString() {
		return "AccountHolder [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", title="
				+ title + ", birthDate=" + birthDate + "]";
	}
	
	
}	 
