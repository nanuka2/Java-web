package com.Nanuka.assignment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    void getAllMoviesReturnsMoviesFromRepository() {
        Category category = new Category("Action");
        List<Movie> movies = List.of(
                new Movie("Inception", "Christopher Nolan", 2010, category),
                new Movie("The Matrix", "Lana Wachowski", 1999, category)
        );
        when(movieRepository.findAll()).thenReturn(movies);

        List<Movie> result = movieService.getAllMovies();

        assertEquals(2, result.size());
        assertSame(movies, result);
        verify(movieRepository).findAll();
    }

    @Test
    void saveMovieSavesMovieInRepository() {
        Movie movie = new Movie("Parasite", "Bong Joon Ho", 2019, new Category("Drama"));

        movieService.saveMovie(movie);

        verify(movieRepository).save(movie);
    }

    @Test
    void getMovieByIdReturnsMovieWhenFound() {
        Movie movie = new Movie("Spirited Away", "Hayao Miyazaki", 2001, new Category("Drama"));
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        Optional<Movie> result = movieService.getMovieById(1L);

        assertTrue(result.isPresent());
        assertSame(movie, result.get());
        verify(movieRepository).findById(1L);
    }

    @Test
    void deleteMovieDeletesMovieById() {
        movieService.deleteMovie(1L);

        verify(movieRepository).deleteById(1L);
    }
}
