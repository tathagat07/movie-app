package com.stackroute.MovieApp.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieControllerTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void saveNewMovie() {
    System.out.println("movie saved");
  }

  @Test
  public void getAllMovies() {
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
}
