package com.cdns.banking.account.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdns.banking.account.model.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, String> {

	AccountEntity findAccountByUserID(String userID);

}
