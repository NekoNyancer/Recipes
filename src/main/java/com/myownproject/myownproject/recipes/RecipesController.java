package com.myownproject.myownproject.recipes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recipes")
public class RecipesController {

    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @GetMapping(path = "/getRecipes")
    public List<Recipes> getRecipes(){
        return recipesService.getRecipes();
    }

    @PostMapping("/addNewRecipe")
    public void addNewRecipe(@RequestBody Recipes recipe){
        recipesService.addNewRecipe(recipe);
    }

    @DeleteMapping(path = "/delete/{recipeId}")
    public void deleteRecipe( @PathVariable("recipeId") Long recipeId){
        recipesService.deleteRecipe(recipeId);
    }

    /*
    @PutMapping( path = "{recipeId}")
    public void updateRecipe( @PathVariable("recipeId") Long recipeId, @RequestParam(required = false) String writer, @RequestParam(required = false) String content){
        recipesService.updateRecipe(recipeId, writer, content);
    }
     */

    @PutMapping( path = "/updateWriter/{recipeId}/{writer}")
    public void updateWriter( @PathVariable("recipeId") Long recipeId, @PathVariable("writer") String writer){
        recipesService.updateWriter(recipeId, writer);
    }

    @PutMapping( path = "/updateContent/{recipeId}/{content}")
    public void updateContent( @PathVariable("recipeId") Long recipeId, @PathVariable("content") String content){
        recipesService.updateContent(recipeId, content);
    }

    @PutMapping( path = "/updateTitle/{recipeId}/{title}")
    public void updateTitle( @PathVariable("recipeId") Long recipeId, @PathVariable("title") String title){
        recipesService.updateTitle(recipeId, title);
    }

    @PutMapping(path = "/updateRecipe/{recipeId}")
    public void updateRecipe(
            @PathVariable("recipeId") Long recipeId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String ingredients,
            @RequestParam(required = false) Long minute
    ){
        recipesService.updateRecipe(recipeId, title, content, ingredients, minute);
    }

}
