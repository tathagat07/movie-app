package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exception.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exception.MovieNotFoundException;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

 @Service
 public class MovieServiceImpl implements MovieService, ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {

   @Value("${movie.1.title:default}")
   String title1;
   @Value("${movie.1.id:default}")
   int id1;
   @Value("${movie.1.release_date:default}")
   String date1;
   @Value("${movie.2.title:default}")
   String title2;
   @Value("${movie.2.id:default}")
   int id2;
   @Value("${musix.2.release_date:default}")
   String date2;

   MovieRepository movieRepository;

  @Autowired
  public MovieServiceImpl(MovieRepository movieRepository){
    super();
    this.movieRepository = movieRepository;
  }

  @Override
  public Movie saveNewMovie(Movie movie) throws MovieAlreadyExistsException {

    if(movieRepository.existsById(movie.getId())){
      throw new MovieAlreadyExistsException("Movie Already Exists");
    }
    Movie savedMovie = movieRepository.save(movie);
    if (savedMovie == null){
      throw new MovieAlreadyExistsException("Movie already exists");
    }

   return savedMovie;
  }

  @Override
  public List<Movie> getAllMovie() {
    return movieRepository.findAll();
  }

  @Override
  public Optional<Movie> getById(int id) throws MovieNotFoundException {
    Optional<Movie> movieId = movieRepository.findById(id);
    if (movieId.isPresent()){
       return movieId;
    }else {
      throw new MovieNotFoundException("Movie Not Found");
    }
  }

  @Override
  public boolean deleteById(int id) throws MovieNotFoundException{
    Optional<Movie> movieId = movieRepository.findById(id);
    if (movieId.isEmpty()){
      throw new MovieNotFoundException("Movie not found");
    }
     movieRepository.deleteById(id);
     return true;

  }

  @Override
  public Movie updateById(Movie movie, int id) throws MovieNotFoundException {
    Optional<Movie> userOptional = movieRepository.findById(id);
    if(userOptional.isEmpty()){
      throw new MovieNotFoundException("Track not found!");
    }
    movie.setId(id);
    movieRepository.save(movie);
    return movie;
  }

  @Override
  public List<Movie> getByName(String title) {
    List<Movie> id = movieRepository.findTitleByName(title);
    return id;
  }


  @Override
  public void run(String... args) throws Exception {

  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    movieRepository.save(new Movie(1, title1, id1, date1));
    movieRepository.save(new Movie(2, title2, id2, date2));
  }
}
