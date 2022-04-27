package com.cdns.banking.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

public class Account {
	
	private String accountID;

	private String userID;

	private String accountNumber;

	private int accountType;

	private int balance;

	private String accountStatus;

	public static class Builder {
	
		private String accountID;

		private String userID;

		private String accountNumber;

		private int accountType;

		private int balance;

		private String accountStatus;
	
	public Builder(String accountNumber) {
        this.accountNumber = accountNumber;
    }
	
	public Builder withUserID(String userID){
        this.userID = userID;

        return this;
    }
	
	public Builder withAccountType(int accountType){
        this.accountType = accountType;

        return this;  
    }
	
	public Builder withBalance(int balance){
        this.balance = balance;

        return this; 
    }
	
	public Builder withAccountStatus(String accountStatus){
        this.accountStatus = accountStatus;

        return this; 
    }
	
	public Account build(){
        /* 
         * Here we create the actual bank account object, 
		 * which is always in a fully initialised state when it's returned.
		 * Since the builder is in the Account class, we can invoke its private constructor.
		 */
		Account account = new Account(); 
		account.accountNumber = this.accountNumber;
        account.userID = this.userID;
        account.accountType = this.accountType;
        account.accountStatus = this.accountStatus;
        account.balance = this.balance;
        return account;
    }
	
	

}
	private Account() {
		
	}
	
}
	
