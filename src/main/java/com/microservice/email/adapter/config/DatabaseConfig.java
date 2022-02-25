package com.microservice.email.adapter.config;

import com.microservice.email.adapter.constant.AppConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfig {

    @Value(AppConstant.DATASOURCE_URL)
    private String url;

    @Value(AppConstant.DATASOURCE_USERNAME)
    private String username;

    @Value(AppConstant.DATASOURCE_PASSWORD)
    private String password;

    @Bean
    public DataSource getDataSource() {
        var dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
