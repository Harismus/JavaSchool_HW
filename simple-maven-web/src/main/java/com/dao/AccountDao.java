package com.dao;

import com.model.Account;

import javax.sql.DataSource;
import java.util.List;

public interface AccountDao {
    public void setDataSource(DataSource dataSource);

    public void createAccount(Account account);

    public Account getAccountById(long id);

    public List<Account> listAccounts();

    public void removeAccount(long id);

    public void updateAccount(long id, String name, String balance);
}
