package com.EmployeeData;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement

@EnableJpaRepositories(
        entityManagerFactoryRef = "cloudEntityManagerFactory",
        basePackages = {"com.EmployeeData"}
)

public class EmployeeConfig {

    @Bean(name = "cloudDataSource")
    @ConfigurationProperties(prefix = "cloud.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "cloudEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    cloudEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("cloudDataSource") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.EmployeeData")
                        .persistenceUnit("cloud")
                        .build();
    }
}
