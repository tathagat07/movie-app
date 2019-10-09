package com.stackroute.MovieApp.configuration;


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

  private String driverClassName;
  private String url;
  private String username;
  private String password;

  @Profile("dev")
  @Bean
  public String devDataBaseConnection(){

    System.out.println("DB Connection for DEV-H2");
    System.out.println(driverClassName);
    System.out.println(url);
    return "DB Connection for DEV-H2";
  }

  @Profile("prod")
  @Bean
  public String prodDataBaseConnection(){

    System.out.println("DB Connection for PROD- High performance instance");
    System.out.println(driverClassName);
    System.out.println(url);
    return "DB Connection for PROD- High performance instance";
  }


}
