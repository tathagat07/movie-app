package com.stackroute.MovieApp.repository;

import com.stackroute.MovieApp.domain.Movie;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie,Integer> {
//  @Query("{ 'name' : ?0 }")
//  List<Movie> findTitleByName(String title);
//  @Query(value = "Select title,overview from movie m where m.title = :title",nativeQuery = true)
  List<Movie> findMovieByTitle( @Param("title") String title);
}
