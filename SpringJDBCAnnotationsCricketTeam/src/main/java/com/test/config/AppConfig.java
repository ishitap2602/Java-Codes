
package com.test.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.test")
public class AppConfig {

    // WRITE (Primary) DataSource
    @Bean
    @Primary
    public DataSource primaryDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/cricket_selection");
        ds.setUsername("root");
        ds.setPassword("root@39");
        ds.setMaximumPoolSize(5);
        ds.setPoolName("PrimaryPool");
        return ds;
    }

    // READ (Replica) DataSource
    @Bean
    public DataSource replicaDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/cricket_selection");
        ds.setUsername("root");
        ds.setPassword("root@39");
        ds.setMaximumPoolSize(5);
        ds.setPoolName("ReplicaPool");
        return ds;
    }

    // Bind write template explicitly to PRIMARY
    @Bean(name = "writeJdbcTemplate")
    public JdbcTemplate writeJdbcTemplate(@Qualifier("primaryDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    // Bind read template explicitly to REPLICA
    @Bean(name = "readJdbcTemplate")
    public JdbcTemplate readJdbcTemplate(@Qualifier("replicaDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
