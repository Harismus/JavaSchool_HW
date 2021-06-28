package com.dao;

import com.model.Account;
import com.util.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateAccountDaoImpl implements AccountDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createAccount(Account account) {
        String SQL = "INSERT INTO ACCOUNTS(id,name,balance) VALUES (?,?,?)";

        jdbcTemplate.update(SQL, account.getId(), account.getName(), account.getBalance());
        System.out.println("ACCOUNTS successfully created.\nName: " + account.getName() + ";\nbalance: " +
                account.getBalance() + "\n");
    }

    @Override
    public Account getAccountById(long id) {
        String SQL = "SELECT * FROM ACCOUNTS WHERE id = ?";
        Account account = (Account) jdbcTemplate.queryForObject(SQL, new Object[]{id}, new AccountMapper());
        return account;
    }

    @Override
    public List<Account> listAccounts() {
        String SQL = "SELECT * FROM ACCOUNTS";
        List<Account> developers = jdbcTemplate.query(SQL, new AccountMapper());
        return developers;
    }

    @Override
    public void removeAccount(long id) {
        String SQL = "DELETE FROM ACCOUNTS WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Developer with id: " + id + " successfully removed");
    }

    @Override
    public void updateAccount(long id, String name, String balance) {
        String SQL = "UPDATE ACCOUNTS SET name = ?, balance = ? WHERE id = ?";
        jdbcTemplate.update(SQL, id, name, balance);
        System.out.println("Account with id: " + id + " successfully updated.");
    }
}
