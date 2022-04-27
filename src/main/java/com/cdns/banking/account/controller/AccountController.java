package com.cdns.banking.account.controller;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdns.banking.account.model.Account;
import com.cdns.banking.account.model.AccountEntity;
import com.cdns.banking.account.service.AccountService;
/*
 * Controller class converts the response to JSON
 * Map HTTP requests onto handler classes
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	//Auto injecting dependent beans
	@Autowired
	AccountService accountService;

	//RequestMethod. GET
	@GetMapping("/phone/{phoneNumber}")
	public String getAccountID(@PathVariable String phoneNumber) {
		return accountService.getAccountByPhoneNumber(phoneNumber).getAccountID();
	}

	@GetMapping("/id/{accountID}")
	public AccountEntity getAccountByAccountID(@PathVariable String accountID) {
		return accountService.getBalanceByAccountID(accountID);
	}

	@GetMapping("/balance/{accountID}")
	public int balance(@PathVariable String accountID) {
		return accountService.getBalanceByAccountID(accountID).getBalance();
	}
	
	
	// RequestMethod.GET
	@GetMapping("/transaction/account_number/{accountNumber}/user_id/{userID}/account_type/{accountType}/balance/{balance}/account_status/{accountStatus}")
	public String updateBalance(@PathVariable String accountNumber, @PathVariable String userID, @PathVariable int accountType, 
			@PathVariable int balance, @PathVariable String accountStatus) {
		Account account = new Account.Builder(accountNumber)
								 .withUserID(userID)
								 .withAccountType(accountType)
								 .withBalance(balance)
								 .withAccountStatus(accountStatus) //dateOpened,atBranch,tracking monthly interest rates
								 .build();
								 
		return accountService.updateAccountAfterTransaction(account);
	}

}
