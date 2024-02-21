package com.udacity.jdnd.course3.critter.web.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource getDataSource() {
        DataSourceBuilder<?> dsb = DataSourceBuilder.create();
        dsb.username("user");
        dsb.password("password");
        dsb.url("jdbc:mysql://localhost:3306/critter_db");
        return dsb.build();
    }
}