package com.example.recipeapp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.recipeapp.domain.Recipe;
import com.example.recipeapp.repositories.RecipeRepository;

public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        when(recipeRepository.findAll()).thenReturn(getRecipesData());
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }

    private HashSet<Recipe> getRecipesData() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);
        return recipeData;
    }
}