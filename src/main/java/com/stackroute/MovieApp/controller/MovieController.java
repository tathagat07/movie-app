package com.stackroute.MovieApp.controller;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.service.MovieService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")
public class MovieController {
  MovieService movieService;

  @Autowired
  Environment environment;

  private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

  @Autowired
  @Qualifier(value = "dummy")
  public void setMovieService(MovieService movieService) {
    this.movieService = movieService;
  }


@PostMapping("/saveNewMovie")
  public ResponseEntity<?> saveNewMovie(@RequestBody Movie movie){

    try {
      logger.info("Movie = "+movie);
      logger.debug("Inside saveMovie()");
      movieService.saveNewMovie(movie);
      return new ResponseEntity<String >("Successfully created.",HttpStatus.CREATED);
    }catch (Exception e){
      logger.error("The Movie already exists");
      return new ResponseEntity<Movie>(movie,HttpStatus.CONFLICT);
    }
}

@GetMapping("/getAllMovies")
  public ResponseEntity<?> getAllMovies(){
  logger.info("All movies = "+movieService.getAllMovie());
  logger.debug("Inside getAllMovies()");
  return new ResponseEntity<Iterable<Movie>>(movieService.getAllMovie(),HttpStatus.OK);
}

@GetMapping("/movie/{id}")
  public ResponseEntity<?> getById(@PathVariable int id){
       Optional<Movie> movies;
    try{

      logger.info("Id"+id);
      logger.debug("Inside getMovieById()");
      movies = movieService.getById(id);
      return new ResponseEntity<Optional<Movie>>(movies,HttpStatus.OK);
    }catch (Exception e){
      logger.error("The Movie does't exist");
      return new ResponseEntity<String>("No such movie found",HttpStatus.CONFLICT);
    }
}

@GetMapping("/delete/{id}")
  public ResponseEntity<?>  deleteById(@RequestBody Movie movie,@PathVariable int id){
    try{
      logger.info("Movie = "+movie+" Id"+id);
      logger.debug("Inside deleteMovie()");
      movieService.deleteById(id);
      return new ResponseEntity<String >("Movie deleted.",HttpStatus.OK);
    }catch (Exception e){
      logger.error("The Movie does't exist");
      return new ResponseEntity<String>("Cannot be deleted because movie doesn't exist",HttpStatus.CONFLICT);
    }

  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateById(@RequestBody Movie movie, @PathVariable int id){
    try {
      logger.info("Movie = "+movie+" Id"+id);
      logger.debug("Inside updateMovie()");
      movieService.updateById(movie, id);
      return new ResponseEntity<>(movieService.updateById(movie,id),HttpStatus.OK);
    }catch (Exception e){
      logger.error("The Movie does't exist");
      return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
    }

  }

  @GetMapping("/titles/{title}")
  public ResponseEntity<List<Movie>> getByName(@RequestParam   String title) {
    List<Movie> movie = movieService.getByName(title);
    return new ResponseEntity<List<Movie>>(movie, HttpStatus.OK);
  }



}
