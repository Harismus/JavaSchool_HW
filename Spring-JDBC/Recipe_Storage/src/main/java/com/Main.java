package com;

import com.config.MyApplicationContextConfiguration;
import com.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext( MyApplicationContextConfiguration.class);
        UserDao userDao = ctx.getBean(UserDao.class);
        System.out.println(userDao.test());
    }
}
