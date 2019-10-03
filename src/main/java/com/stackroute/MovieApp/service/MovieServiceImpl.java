package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

  MovieRepository movieRepository;

  @Autowired
  public MovieServiceImpl(MovieRepository movieRepository){
    this.movieRepository = movieRepository;
  }

  @Override
  public Movie saveNewMovie(Movie movie)  {
//    if(movieRepository.existsById(movie.getId())){
//      throw new Exception("Movie already exits");
//    }
    Movie savedMovie = movieRepository.save(movie);
//    if(savedMovie == null)
//    {
//      throw new Exception("Movie already exists.");
//    }
    return savedMovie;
  }

  @Override
  public List<Movie> getAllMovie() {
    return movieRepository.findAll();
  }

  @Override
  public Optional<Movie> getById(int id) {
    Optional<Movie> movieId = movieRepository.findById(id);
//    if (movieId.isEmpty()){
//      throw new Exception("Movie not found");
//    }
    return movieId;
  }

  @Override
  public boolean deleteById(int id){
    Optional<Movie> movieId = movieRepository.findById(id);
//    if (movieId.isEmpty()){
//      throw new Exception("Movie not found");
//    }
     movieRepository.deleteById(id);
     return true;

  }

  @Override
  public Movie updateById(Movie movie, int id) {
    Optional<Movie> userOptional = movieRepository.findById(id);
//    if(userOptional.isEmpty()){
//      throw new Exception("Track not found!");
//    }
    movie.setId(id);
    movieRepository.save(movie);
    return movie;
  }


}
