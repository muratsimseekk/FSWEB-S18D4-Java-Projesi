package com.workintechs18d4project.S18D4.service;

import com.workintechs18d4project.S18D4.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccounts();
    Account findAccountByID(Long accountID);
    Account addAccount (Account account );
    Account upodateAccount(Account account , Long customerID);
    Account removeAccount(Long id);
}
