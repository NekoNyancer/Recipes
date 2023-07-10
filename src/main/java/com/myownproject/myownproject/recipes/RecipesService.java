package com.myownproject.myownproject.recipes;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipesService {

    private final RecipesRepository recipesRepository;

    @Autowired
    public RecipesService(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }


    public List<Recipes> getRecipes(){
        return recipesRepository.findAll();
    }

    public void addNewRecipe(Recipes recipe) {

        Optional<Recipes> optionalRecipes = recipesRepository.findRecipesByWriterAndTitle(recipe.getWriter(), recipe.getTitle());


        if (optionalRecipes.isPresent()){
            throw new IllegalStateException("This writer already has that recipe");
        }
        recipesRepository.save(recipe);
        System.out.println(recipe);
    }

    public void deleteRecipe(Long recipeId) {
        boolean exists = recipesRepository.existsById(recipeId);

        if( !exists ){
            throw new IllegalStateException("Recipe doesn't exist: " + recipeId + "!");
        }

        recipesRepository.deleteById(recipeId);

    }

    /*
    @Transactional
    public void updateRecipe(Long recipeId, String writer, String content) {

        Recipes recipes = recipesRepository.findById(recipeId).orElseThrow( () -> new IllegalStateException( "Not found the recipe" ) );

        if ( writer != null && writer.length() > 0 && !Objects.equals(recipes.getWriter(), writer )){
            recipes.setWriter(writer);
        }

        if ( content != null && content.length() > 0 && !Objects.equals(recipes.getContent(), content )){
            recipes.setContent(content);
        }
    }
     */

    @Transactional
    public void updateWriter(Long recipeId, String writer) {
        Recipes recipe = recipesRepository.findById(recipeId).orElseThrow( () -> new IllegalStateException( "Not found the recipe" ) );

        if (writer != null && writer.length() > 0){
            recipe.setWriter(writer);
            recipesRepository.save(recipe);
        }

    }

    @Transactional
    public void updateContent(Long recipeId, String content) {
        Recipes recipe = recipesRepository.findById(recipeId).orElseThrow( () -> new IllegalStateException("Recipe not found") );

        if (content != null && content.length() > 0){
            recipe.setContent(content);
        }
    }

    @Transactional
    public void updateTitle(Long recipeId, String title) {
        Recipes recipe = recipesRepository.findById(recipeId).orElseThrow( () -> new IllegalStateException( "Recipe not found" ) );

        if ( title != null && title.length() > 0){
            recipe.setTitle(title);
        }
    }

    @Transactional
    public void updateRecipe(Long recipeId, String title, String content, String ingredients, Long minute) {
        //Recipes recipe = recipesRepository.findById(recipeId).orElseThrow(() -> new IllegalStateException( "Recipe not found" ) );

        Recipes recipe = recipesRepository.findById(recipeId).orElseGet(null);

        if ( recipe != null ){
            if ( title != null && title.length() > 0 && !Objects.equals(recipe.getTitle(), title )){
                recipe.setTitle(title);
            }

            if ( content != null && content.length() > 0 && !Objects.equals(recipe.getContent(), content )){
                recipe.setContent(content);
            }

            if ( ingredients != null && ingredients.length() > 0 && !Objects.equals(recipe.getIngredients(), ingredients )){
                recipe.setIngredients(ingredients);
            }

            if ( minute != null && minute > 0 && !Objects.equals(recipe.getMinute(), minute )){
                recipe.setMinute(minute);
            }

        }




    }
}
