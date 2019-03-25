package com.example.recipeapp.service;

import java.util.Set;

import com.example.recipeapp.domain.Recipe;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
