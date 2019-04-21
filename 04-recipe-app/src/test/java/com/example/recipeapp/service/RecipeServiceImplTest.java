package com.example.recipeapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
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

    private Set<Recipe> getRecipesData() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);
        return recipeData;
    }

    private Optional<Recipe> getOptionalRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        return Optional.of(recipe);
    }

    @Test
    public void getRecipeByIdTest() {
        when(recipeRepository.findById(anyLong())).thenReturn(getOptionalRecipe());
        Recipe returnedRecipe = recipeService.findById(1L);
        assertNotNull(returnedRecipe);
        // default times() = 1, it can be omitted
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}