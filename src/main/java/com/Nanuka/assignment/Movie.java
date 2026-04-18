package com.Nanuka.assignment;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Movie name is required")
    private String movieName;

    @NotBlank(message = "Director is required")
    private String director;

    @Min(value = 1888, message = "Year must be valid")
    @Column(name = "release_year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Movie() {
    }

    public Movie(String movieName, String director, int year, Category category) {
        this.movieName = movieName;
        this.director = director;
        this.year = year;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}