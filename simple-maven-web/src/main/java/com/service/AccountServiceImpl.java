package com.service;

import com.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {

    Account account;

    @Override
    public void open(Account account) {
        this.account = account;
    }

    @Override
    public Account findOne(Long accountId) {
        return account;
    }
}
