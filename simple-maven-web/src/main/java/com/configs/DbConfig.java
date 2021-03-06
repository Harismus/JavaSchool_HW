package com.configs;


import com.dao.JdbcTemplateAccountDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DbConfig {
    @Value("${driverClassName}")
    private  String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${myusername}" )
    private String username;
    @Value("${password}")
    private String password;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JdbcTemplateAccountDaoImpl jdbcTemplateAccountDaoImpl() throws Exception {
        DataSource dataSource = dataSource();
        if (dataSource != null)
            return new JdbcTemplateAccountDaoImpl();
        else
            throw new Exception("Не удалось создать");
    }

    @Lazy
    @Bean
    public DataSource dataSource() {
        try {
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            Class<? extends Driver> driver = (Class<?extends Driver>) Class.forName( driverClassName );
            dataSource.setDriverClass(driver);
            dataSource.setUrl( url );
            dataSource.setUsername( username );
            dataSource.setPassword( password );
            return dataSource;
        } catch (Exception e) {
            return null;
        }
    }
}

