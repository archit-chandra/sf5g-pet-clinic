package com.example.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
