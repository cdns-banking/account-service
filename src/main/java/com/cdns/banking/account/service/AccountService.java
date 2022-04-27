package com.cdns.banking.account.service;

import com.cdns.banking.account.model.AccountEntity;

public interface AccountService {
	
	public AccountEntity getAccountByPhoneNumber(String phoneNumber);
	
	public AccountEntity getBalanceByAccountID(String accountID);
	
	public String updateAccountAfterTransaction(AccountEntity account);	
}
