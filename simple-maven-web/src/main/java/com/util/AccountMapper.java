package com.util;

import com.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account developer = new Account();
        developer.setId(rs.getInt("id"));
        developer.setName(rs.getString("name"));
        developer.setBalance(rs.getString("balance"));
        return developer;
    }
}
