package com.stackroute.MovieApp.bootstrap;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class bootsTrapDB implements ApplicationListener<ContextRefreshedEvent> {

  private MovieRepository movieRepository;

  @Autowired
  public bootsTrapDB(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    Movie.builder().title("Alice").release_date("2018-20-09").id(20).overview("thriller").build();
   	Movie movie1 = new Movie(10,"Godfather","2003-12-09","The godfather",2000);
		movieRepository.save(movie1);
  }
}
