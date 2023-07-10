package com.myownproject.myownproject.recipes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class RecipesConfig {

    @Bean
    CommandLineRunner commandLineRunner(RecipesRepository repository) {
        return args -> {
            Recipes scrumbledEgg = new Recipes(
                    "scrumbled egg",
                    "Balazs",
                    LocalDate.now(),
                    "Get some eggs beat them like your meat at night. Pour it into a pan and stir on low heat. You can season as you like, just leave your love juice out of it",
                    "Tojás, só, bors",
                    10L
            );

            Recipes toast = new Recipes(
                    "toast",
                    "Balazs",
                    LocalDate.now(),
                    "Grab a slice of bread put it in a toaster and DONE. If you don't have a toaster you cheap fuk put it in a pan and burn your house down",
                    "Kenyér",
                    5L
            );

            //repository.saveAll( List.of(scrumbledEgg, toast) );
        };
    }
}