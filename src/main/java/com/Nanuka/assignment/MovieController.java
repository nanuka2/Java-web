package com.Nanuka.assignment;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public MovieController(MovieService movieService,
                           CategoryService categoryService,
                           CategoryRepository categoryRepository) {
        this.movieService = movieService;
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Movie Page");
        model.addAttribute("movies", movieService.getAllMovies());
        return "index";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("movieForm", new MovieForm());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("movieForm") MovieForm movieForm,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "form";
        }

        Category category = null;
        if (movieForm.getCategoryId() != null) {
            category = categoryRepository.findById(movieForm.getCategoryId()).orElse(null);
        }

        Movie movie = new Movie();
        movie.setMovieName(movieForm.getMovieName());
        movie.setDirector(movieForm.getDirector());
        movie.setYear(movieForm.getYear());
        movie.setCategory(category);

        movieService.saveMovie(movie);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/";
    }
}