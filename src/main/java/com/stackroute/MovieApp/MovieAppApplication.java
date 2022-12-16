package com.stackroute.MovieApp;

import com.stackroute.MovieApp.controller.MovieController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MovieAppApplication  {
    private static final Logger logger = LoggerFactory.getLogger(MovieAppApplication.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MovieAppApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//      String sql = "INSERT INTO MOVIE (id,title,release_date,overview,revenue) VALUES ()";
//      int rows = jdbcTemplate.update(sql);
//      if(rows> 0){
//         logger.info("A new row has been inserted");
//
//      }
//    }
}
