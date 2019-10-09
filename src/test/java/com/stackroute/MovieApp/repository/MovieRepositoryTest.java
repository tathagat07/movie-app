package com.stackroute.MovieApp.repository;

import com.stackroute.MovieApp.domain.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieRepositoryTest {
  MovieRepository movieRepository;
  Movie movie;

  @Before
  public void setUp() {
    movie = new Movie();
    movie.setId(10);
    movie.setTitle("The Machinist");
    movie.setOverview("Tgdd dhd ");
    movie.setRelease_date("2006-12-09");
    movie.setRevenue(1000);

  }

  @After
  public void tearDown() {
    movieRepository.deleteAll();
  }

  @Test
  public void testSaveNewMovie(){
    movieRepository.save(movie);
    Movie fetchMovie = movieRepository.findById(movie.getId()).get();
    Assert.assertEquals(10,fetchMovie.getId());
  }

  @Test
  public void testSaveNewMovieFailure(){
    Movie testMovie = new Movie(20,"The godfather","2006-12-09","tdfd gvdd d",2000);
    movieRepository.save(movie);
    Movie fetchUser = movieRepository.findById(movie.getId()).get();
   Assert.assertNotSame(testMovie,movie);
  }

}
