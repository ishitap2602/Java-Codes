
package com.example.cricket.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

    @Bean(name = "statsDataSource")
    @ConfigurationProperties("stats-datasource")
    public HikariDataSource statsDataSource() {
        return new HikariDataSource();
    }

    @Bean(name = "selectionDataSource")
    @ConfigurationProperties("selection-datasource")
    public HikariDataSource selectionDataSource() {
        return new HikariDataSource();
    }

    @Bean(name = "statsJdbcTemplate")
    public JdbcTemplate statsJdbcTemplate(@Qualifier("statsDataSource") HikariDataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = "selectionJdbcTemplate")
    public JdbcTemplate selectionJdbcTemplate(@Qualifier("selectionDataSource") HikariDataSource ds) {
        return new JdbcTemplate(ds);
    }
}
