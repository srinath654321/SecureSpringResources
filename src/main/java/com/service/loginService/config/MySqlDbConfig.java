package com.service.loginService.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.sql.SQLException;

@Configuration
public class MySqlDbConfig {

    private static final Logger LOG = LoggerFactory.getLogger(MySqlDbConfig.class);

    private HikariDataSource dataSource;

    @Bean
    @ConfigurationProperties("spring.datasource")
    public HikariDataSource makeDbConnection() {
        LOG.info("opening database connection using hicari cp");
        dataSource = (HikariDataSource) DataSourceBuilder.create().build();
        return dataSource;
    }

    @PreDestroy
    public void closeConnection() throws SQLException {
        LOG.info("closing database connection");
        if (!dataSource.isClosed()) {
            dataSource.close();
        }
    }
}
