package com.Nanuka.assignment;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewerName;
    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review() {}

    public Review(String reviewerName, String comment, int rating, Movie movie) {
        this.reviewerName = reviewerName;
        this.comment = comment;
        this.rating = rating;
        this.movie = movie;
    }

    public int getRating() { return rating; }
}