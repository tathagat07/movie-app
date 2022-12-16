package com.siemens.movieApp.controller;

import com.siemens.movieApp.domain.Movie;
import com.siemens.movieApp.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @PostMapping("/saveNewMovie")
    public ResponseEntity<?> saveNewMovie(@RequestBody Movie movie) {

        try {
            movieService.saveNewMovie(movie);
            logger.info("Successfully created with id:" + movie.getId());
            return new ResponseEntity<String>("Successfully created with id: " + movie.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Movie Already Exists", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<?> getAllMovies() {
        return new ResponseEntity<Iterable<Movie>>(movieService.getAllMovie(), HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<Movie> movies;
        try {
            movies = movieService.getById(id);
            return new ResponseEntity<Optional<Movie>>(movies, HttpStatus.OK);
        } catch (Exception e) {
            logger.info("No such movie found");
            return new ResponseEntity<String>("No such movie found", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            movieService.deleteById(id);
            logger.info("Movie deleted.");
            return new ResponseEntity<String>("Movie deleted.", HttpStatus.OK);
        } catch (Exception e) {
            logger.info("Cannot be deleted since movie doesn't exist");
            return new ResponseEntity<String>("Cannot be deleted since movie doesn't exist", HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@RequestBody Movie movie, @PathVariable int id) {
        try {
            movieService.updateById(movie, id);
            logger.info("movie with id: " + id + " updated successfully");
            return new ResponseEntity<>(movieService.updateById(movie, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/titles/{title}")
    public ResponseEntity<List<Movie>> getByName(@RequestParam String title) {
        List<Movie> movie = movieService.getByName(title);
        return new ResponseEntity<List<Movie>>(movie, HttpStatus.OK);
    }


}
