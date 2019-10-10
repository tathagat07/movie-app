package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exception.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exception.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MovieService {

  public Movie saveNewMovie(Movie movie) throws MovieAlreadyExistsException;

  public List<Movie> getAllMovie();

  public Optional<Movie> getById(int id) throws MovieNotFoundException ;

  public boolean deleteById(int id) throws MovieNotFoundException;

  public Movie updateById(Movie movie, int id) throws MovieNotFoundException ;

  public List<Movie> getByName(String title);

}
