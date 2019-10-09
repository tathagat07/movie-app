package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exception.MovieAlreadyExistsException;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

  Movie movie;

  @Mock
  MovieRepository movieRepository;

  @InjectMocks
  MovieServiceImpl movieService;
  List<Movie> list = null;
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    movie = new Movie();
    movie.setId(10);
    movie.setTitle("The Machinist");
    movie.setOverview("Tgdd dhd ");
    movie.setRelease_date("2006-12-09");
    movie.setRevenue(1000);

    list = new ArrayList<>();
    list.add(movie);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void saveNewMovieTestSuccess() throws MovieAlreadyExistsException {

    when(movieRepository.save((Movie) any())).thenReturn(movie);
    Movie savedMovie = movieService.saveNewMovie(movie);
    Assert.assertEquals(movie,savedMovie);

    //verify here verifies that userRepository save method is only called once
    verify(movieRepository,times(1)).save(movie);
  }

  @Test(expected = MovieAlreadyExistsException.class)
  public void saveNewMovieTestFailure() throws MovieAlreadyExistsException{
    when(movieRepository.save((Movie) any())).thenReturn(null);
    Movie savedMovie = movieService.saveNewMovie(movie);
    System.out.println("savedUser" + savedMovie);
  }

  @Test
  public void getAllMovie() {
    movieRepository.save(movie);
    //stubbing the mock to return specific data
    when(movieRepository.findAll()).thenReturn(list);
    List<Movie> userlist = movieService.getAllMovie();
    Assert.assertEquals(list,userlist);
  }

  @Test
  public void getById() {
  }

  @Test
  public void deleteById() {
  }

  @Test
  public void updateById() {
  }

  @Test
  public void getByName() {
  }
}
