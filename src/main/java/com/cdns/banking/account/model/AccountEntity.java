package com.cdns.banking.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
//Specifying name of the database table to be used for mapping
@Table(name = "t_account")
public class AccountEntity {

	/*
	 * @Id annotation specifies the primary key 
	 * @GeneratedValues specifies generation strategies for the values of primary keys.
	 * @GenericGenerator Denotes custom generator
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})
	@GeneratedValue(generator = "generator")
	@Column(name = "account_id")
	private String accountID;

	@Column(name = "userid")
	private String userID;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "account_type")
	private int accountType;

	@Column(name = "balance")
	private int balance;

	@Column(name = "account_status")
	private String accountStatus;

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	

}
