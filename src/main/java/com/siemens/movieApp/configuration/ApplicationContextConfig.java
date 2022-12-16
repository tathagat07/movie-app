package com.siemens.movieApp.configuration;


import com.siemens.movieApp.controller.MovieController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ConfigurationProperties("spring.datasource")
@EnableTransactionManagement
@SuppressWarnings("unused")
public class ApplicationContextConfig {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);


    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDataBaseConnection() {

        logger.info("DB Connection for mySQL");
        logger.info("driverClassName: ", driverClassName);
        logger.info("url",url);
        return "DB Connection for DEV-MYSQL";
    }

    @Profile("prod")
    @Bean
    public String prodDataBaseConnection() {

        logger.info("DB Connection for PROD- High performance instance ");
        logger.info("driverClassName: ", driverClassName);
        logger.info("url",url);
        return "DB Connection for PROD- High performance instance";
    }
}
