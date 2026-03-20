package com.Nanuka.assignment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "Movie Page");

        model.addAttribute("movieName", "Inception");
        model.addAttribute("description", "A thief who steals corporate secrets through dream-sharing technology.");
        model.addAttribute("rating", "8.8");
        model.addAttribute("genre", "Sci-Fi, Action");
        model.addAttribute("year", "2010");

        return "index";
    }
}
