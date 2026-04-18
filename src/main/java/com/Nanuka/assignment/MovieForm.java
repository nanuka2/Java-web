package com.Nanuka.assignment;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MovieForm {

    @NotBlank(message = "Movie name is required")
    private String movieName;

    @NotBlank(message = "Director is required")
    private String director;

    @Min(value = 1888, message = "Year must be valid")
    private int year;

    private Long categoryId;

    public MovieForm() {
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}