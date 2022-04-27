package com.cdns.banking.account.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cdns.banking.account.model.AccountEntity;
import com.cdns.banking.account.model.User;
import com.cdns.banking.account.model.repository.AccountRepository;
import com.cdns.banking.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public AccountEntity getAccountByPhoneNumber(String phoneNumber) {
		User user = restTemplate.getForObject("http://main-service/phone/" + phoneNumber, User.class);
		return accountRepository.findAccountByUserID(user.getUserID());
	}

	@Override
	public AccountEntity getBalanceByAccountID(String accountID) {
		Optional<AccountEntity> account = accountRepository.findById(accountID);
		return account.isPresent() ? account.get() : null;
	}

	@Override
	public String updateAccountAfterTransaction(AccountEntity account) {
		return accountRepository.save(account).toString();
	}
}
