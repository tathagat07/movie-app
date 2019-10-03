package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exception.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exception.MovieNotFoundException;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

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


}
