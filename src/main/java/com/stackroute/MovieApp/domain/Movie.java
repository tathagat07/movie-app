package com.stackroute.MovieApp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "Movie")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Movie {

  @Id
  private int id;
  private String title;
  private String release_date;
  private String overview;
  private int revenue;

  public Movie(int id, String title, String release_date) {
  }


}
