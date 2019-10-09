package com.stackroute.MovieApp.seedData;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class AppListener implements ApplicationListener<ContextRefreshedEvent> {

  @Value("${movie.1.title:default}")
  String title;
  @Value("${movie.1.id:default}")
  int id;
  @Value("${movie.1.release_date:default}")
  String release_date;

  MovieRepository movieRepository;

  @Autowired
  public AppListener(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    System.out.println("in movie service impl");
    movieRepository.save(new Movie(id, title, release_date));
  }
}
