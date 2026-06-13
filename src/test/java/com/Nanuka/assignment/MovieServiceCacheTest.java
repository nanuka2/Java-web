package com.Nanuka.assignment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MovieServiceCacheTest.TestConfig.class)
class MovieServiceCacheTest {

    @jakarta.annotation.Resource
    private MovieService movieService;

    @jakarta.annotation.Resource
    private MovieRepository movieRepository;

    @Test
    void getAllMoviesUsesCacheUntilMovieIsSaved() {
        List<Movie> movies = List.of(new Movie("Inception", "Christopher Nolan", 2010, new Category("Action")));
        when(movieRepository.findAll()).thenReturn(movies);

        movieService.getAllMovies();
        movieService.getAllMovies();

        verify(movieRepository, times(1)).findAll();

        movieService.saveMovie(new Movie("Parasite", "Bong Joon Ho", 2019, new Category("Drama")));
        movieService.getAllMovies();

        verify(movieRepository, times(2)).findAll();
    }

    @Configuration
    @EnableCaching
    static class TestConfig {

        @Bean
        CacheManager cacheManager() {
            return new ConcurrentMapCacheManager("movies");
        }

        @Bean
        MovieRepository movieRepository() {
            return mock(MovieRepository.class);
        }

        @Bean
        MovieService movieService(MovieRepository movieRepository) {
            return new MovieService(movieRepository);
        }
    }
}
