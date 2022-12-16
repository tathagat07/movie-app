package com.siemens.movieApp.service;

import com.siemens.movieApp.domain.Movie;
import com.siemens.movieApp.exception.MovieAlreadyExistsException;
import com.siemens.movieApp.exception.MovieNotFoundException;
import com.siemens.movieApp.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        super();
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveNewMovie(Movie movie) throws MovieAlreadyExistsException {

        if (movieRepository.existsById(movie.getId())) {
            logger.info("Movie Already Exists");
            throw new MovieAlreadyExistsException("Movie Already Exists");
        }
        Movie savedMovie = movieRepository.save(movie);
        if (savedMovie == null) {
            logger.info("Movie Already Exists");
            throw new MovieAlreadyExistsException("Movie already exists");
        }

        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getById(int id) throws MovieNotFoundException {
        Optional<Movie> movieId = movieRepository.findById(id);
        if (movieId.isPresent()) {
            return movieId;
        } else {
            logger.info("Movie Not Found");
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

    @Override
    public boolean deleteById(int id) throws MovieNotFoundException {
        Optional<Movie> movieId = movieRepository.findById(id);
        if (movieId.isEmpty()) {
            logger.info("Movie Not Found");
            throw new MovieNotFoundException("Movie not found");
        }
        movieRepository.deleteById(id);
        return true;

    }

    @Override
    public Movie updateById(Movie movie, int id) throws MovieNotFoundException {
        Optional<Movie> userOptional = movieRepository.findById(id);
        if (userOptional.isEmpty()) {
            logger.info("Movie Not Found");
            throw new MovieNotFoundException("Movie not found!");
        }
        movie.setId(id);
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public List<Movie> getByName(String title) {
        List<Movie> id = movieRepository.findTitleByName(title);
        return id;
    }


}
