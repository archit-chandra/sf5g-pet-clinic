package com.example.recipeapp.service;

import java.util.Set;

import com.example.recipeapp.commands.RecipeCommand;
import com.example.recipeapp.domain.Recipe;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    void deleteById(Long id);
}
