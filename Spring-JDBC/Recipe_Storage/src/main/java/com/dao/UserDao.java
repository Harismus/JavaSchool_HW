package com.dao;


import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao {
    //private DataSource dataSource;

//    public UserDao(@Autowired DataSource dataSource) {
//
//        this.dataSource = dataSource;
//    }

    public UserDao() {

    }

    public String test() {
        return "test";
    }
}
