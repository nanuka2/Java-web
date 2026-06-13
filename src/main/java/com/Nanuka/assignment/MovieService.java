package com.Nanuka.assignment;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Cacheable("movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @CacheEvict(value = "movies", allEntries = true)
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @CacheEvict(value = "movies", allEntries = true)
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
