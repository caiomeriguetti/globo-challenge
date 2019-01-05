package com.globo.challenge.config;

import com.github.mongobee.Mongobee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Configuration
@Order(999)
public class MongobeeConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongodbUri;

    @Bean
    public Mongobee mongobee(){
        Mongobee runner = new Mongobee(mongodbUri);
        runner.setChangeLogsScanPackage(
                "com.globo.challenge.dbchanges");

        return runner;
    }
}
