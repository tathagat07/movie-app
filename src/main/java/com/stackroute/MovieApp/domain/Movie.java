package com.stackroute.MovieApp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
  @Id
  private int id;
  private String title;
  private String release_date;
  private String overview;
  private int revenue;

  public Movie() {
  }

  public Movie(int id, String title, String release_date, String overview, int revenue) {
    this.id = id;
    this.title = title;
    this.release_date = release_date;
    this.overview = overview;
    this.revenue = revenue;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getRelease_date() {
    return release_date;
  }

  public void setRelease_date(String release_date) {
    this.release_date = release_date;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public int getRevenue() {
    return revenue;
  }

  public void setRevenue(int revenue) {
    this.revenue = revenue;
  }

  @Override
  public String   toString() {
    return "movie{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", release_date='" + release_date + '\'' +
      ", overview='" + overview + '\'' +
      ", revenue=" + revenue +
      '}';
  }
}
