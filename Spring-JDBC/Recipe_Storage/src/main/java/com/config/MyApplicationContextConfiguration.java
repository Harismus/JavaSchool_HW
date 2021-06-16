package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.utils.MysqlDataSource;

import javax.sql.DataSource;


@Configuration
@ComponentScan("com.*")
public class MyApplicationContextConfiguration {  // (1)

    @Bean
    public DataSource dataSource() {  // (2)
        MysqlDataSource dataSource = new MysqlDataSource();

        return dataSource;
    }


//    @Bean
//    public UserDao userDao() { // (3)
//        return new UserDao(dataSource());
//    }

}