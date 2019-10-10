//package com.stackroute.MovieApp.repository;
//
//import com.stackroute.MovieApp.domain.Movie;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class MovieRepositoryTest {
//
//  @Autowired
//  MovieRepository movieRepository;
//  Movie movie;
//
//  @Before
//  public void  setUp() {
//    movie = new Movie();
//    movie.setId(10);
//    movie.setTitle("The Machinist");
//    movie.setOverview("Tgdd dhd ");
//    movie.setRelease_date("2006-12-09");
//    movie.setRevenue(1000);
//
//  }
//
//  @After
//  public void tearDown() {
//    movieRepository.deleteAll();
//  }
//
//  @Test
//  public void testSaveNewMovie(){
//    movieRepository.save(movie);
//    Movie fetchMovie = movieRepository.findById(movie.getId()).get();
//    Assert.assertEquals(10,fetchMovie.getId());
//  }
//
//  @Test
//  public void testSaveNewMovieFailure(){
//    Movie testMovie = new Movie(20,"The godfather","2006-12-09","the fvfvf",2000);
//    movieRepository.save(movie);
//    Movie fetchUser = movieRepository.findById(movie.getId()).get();
//   Assert.assertNotSame(testMovie,movie);
//  }
//
//  @Test
//  public void testGetAllMovies(){
//    Movie movie1 = new Movie(20,"The godfather","2006-12-09","the fvfvf",2000);
//    Movie movie2 = new Movie(230,"godfather","2006-12-10","the new",2050);
//
//    movieRepository.save(movie1);
//    movieRepository.save(movie2);
//
//    List<Movie> list  = movieRepository.findAll();
//    Assert.assertEquals("godfather", list.get(1).getTitle());
//  }
//
//}
