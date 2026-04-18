package com.Nanuka.assignment;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repo;

    public ReviewService(ReviewRepository repo) {
        this.repo = repo;
    }

    public Review saveReview(Review r) {
        return repo.save(r);
    }

    public List<Review> getAllReviews() {
        return repo.findAll();
    }
}

