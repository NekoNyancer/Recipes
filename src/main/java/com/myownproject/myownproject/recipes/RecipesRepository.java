package com.myownproject.myownproject.recipes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Long> {

    Optional<Recipes> findRecipesByWriterAndTitle(String writer, String title);


}
