package com.service;

import com.model.Account;


public interface AccountService {
    void open(Account account);

     Account findOne(Long accountId) ;

}
