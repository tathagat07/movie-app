package com.stackroute.MovieApp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
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

  public Movie(String title, int id, String release_date) {
  }
}
