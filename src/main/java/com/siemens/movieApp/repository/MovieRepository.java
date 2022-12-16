package com.siemens.movieApp.repository;

import com.siemens.movieApp.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
  @Query(value = "Select title,overview from movie m where m.title = :title",nativeQuery = true)
  List<Movie> findTitleByName( @Param("title") String title);
}
