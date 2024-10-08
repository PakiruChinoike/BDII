package br.ifsul.bdii.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DataSourceConfig {
    
    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {
        DataSourceBuilder dsBuilder = DataSourceBuilder.create();
            dsBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
            dsBuilder.url("jdbc:mysql://localhost:3306/biblio_alexandria");
            dsBuilder.username("root");
            dsBuilder.password("root");
            return dsBuilder.build();       
    }

    @Bean
    void databaseRun() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(
            new ClassPathResource("src/main/resources/data.sql"));
        populator.execute(this.dataSource());
    }
}
