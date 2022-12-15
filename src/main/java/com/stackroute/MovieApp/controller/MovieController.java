package com.stackroute.MovieApp.controller;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }


@PostMapping("/saveNewMovie")
  public ResponseEntity<?> saveNewMovie(@RequestBody Movie movie){

    try {
      movieService.saveNewMovie(movie);
      return new ResponseEntity<String >("Successfully created with id :"+movie.getId(),HttpStatus.CREATED);
    }catch (Exception e){
      return new ResponseEntity<Movie>(movie,HttpStatus.CONFLICT);
    }
}

@GetMapping("/getAllMovies")
  public ResponseEntity<?> getAllMovies(){
  return new ResponseEntity<Iterable<Movie>>(movieService.getAllMovie(),HttpStatus.OK);
}

@GetMapping("/movie/{id}")
  public ResponseEntity<?> getById(@PathVariable int id){
       Optional<Movie> movies;
    try{
      movies = movieService.getById(id);
      return new ResponseEntity<Optional<Movie>>(movies,HttpStatus.OK);
    }catch (Exception e){

      return new ResponseEntity<String>("No such movie found",HttpStatus.CONFLICT);
    }
}

@DeleteMapping("/delete/{id}")
  public ResponseEntity<?>  deleteById(@PathVariable int id){
    try{
      movieService.deleteById(id);
      return new ResponseEntity<String >("Movie deleted.",HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<String>("Cannot be deleted because movie doesn't exist",HttpStatus.CONFLICT);
    }

  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateById(@RequestBody Movie movie, @PathVariable int id){
    try {
      movieService.updateById(movie, id);
      return new ResponseEntity<>(movieService.updateById(movie,id),HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
    }

  }


}
