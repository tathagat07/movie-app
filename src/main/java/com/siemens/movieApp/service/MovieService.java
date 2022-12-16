package com.siemens.movieApp.service;

import com.siemens.movieApp.domain.Movie;
import com.siemens.movieApp.exception.MovieAlreadyExistsException;
import com.siemens.movieApp.exception.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

  public Movie saveNewMovie(Movie movie) throws MovieAlreadyExistsException;

  public List<Movie> getAllMovie();

  public Optional<Movie> getById(int id) throws MovieNotFoundException;

  public boolean deleteById(int id) throws MovieNotFoundException;

  public Movie updateById(Movie movie, int id) throws MovieNotFoundException ;

  public List<Movie> getByName(String title);

}
