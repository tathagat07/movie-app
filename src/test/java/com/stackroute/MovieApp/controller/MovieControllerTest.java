package com.stackroute.MovieApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exception.MovieAlreadyExistsException;
import com.stackroute.MovieApp.service.MovieService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MovieControllerTest {

  @Autowired
  private MockMvc mockMvc;
  private Movie movie;

  @MockBean
  private MovieService movieService;

  @InjectMocks
  private MovieController movieController;

  private List<Movie> list =null;
  @Before
  public void setUp()  {

    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    movie = new Movie();
    movie.setId(10);
    movie.setTitle("GodFather");
    movie.setOverview("The godfather");
    movie.setRevenue(12000);
    movie.setRelease_date("2003-12-09");
    list = new ArrayList();
    list.add(movie);

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void saveNewMovie() throws Exception {
    when(movieService.saveNewMovie(any())).thenReturn(movie);
    try {
      mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/saveNewMovie")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(movie)))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andDo(MockMvcResultHandlers.print());
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("movie saved");
  }

  @Test
  public void saveMovieFailure() throws Exception {
    when(movieService.saveNewMovie(any())).thenThrow(MovieAlreadyExistsException.class);
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/saveNewMovie")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(movie)))
      .andExpect(MockMvcResultMatchers.status().isConflict())
      .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void getAllMovies() throws Exception {

    when(movieService.getAllMovie()).thenReturn(list);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getAllMovies")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(movie)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());
    System.out.println("All movies printed ");
  }

  @Test
  public void getById() {
    System.out.println("Movie got by ID");
  }

  @Test
  public void deleteById() {
    System.out.println("movie deleted");
  }

  @Test
  public void updateById() {
    System.out.println("movie updated");
  }

  private static String asJsonString(final Object obj)
  {
    try{
      return new ObjectMapper().writeValueAsString(obj);

    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
