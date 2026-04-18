package com.Nanuka.assignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DataLoader(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category("Action"));
            categoryRepository.save(new Category("Comedy"));
            categoryRepository.save(new Category("Drama"));
            categoryRepository.save(new Category("Horror"));
        }
    }
}