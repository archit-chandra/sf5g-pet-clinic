package com.example.recipeapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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

import com.example.recipeapp.commands.RecipeCommand;
import com.example.recipeapp.converters.RecipeCommandToRecipe;
import com.example.recipeapp.converters.RecipeToRecipeCommand;
import com.example.recipeapp.domain.Recipe;
import com.example.recipeapp.exceptions.NotFoundException;
import com.example.recipeapp.repositories.RecipeRepository;

public class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipesTest() throws Exception {
        when(recipeRepository.findAll()).thenReturn(getRecipesData());
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1, recipes.size());
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
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
    public void getRecipeByIdTest() throws Exception {
        when(recipeRepository.findById(anyLong())).thenReturn(getOptionalRecipe());
        Recipe returnedRecipe = recipeService.findById(1L);
        assertNotNull(returnedRecipe);
        // default times() = 1, it can be omitted
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdTestNotFound() throws Exception {
        Optional<Recipe> recipeOptional = Optional.empty();
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.findById(1L);
        //should go boom
    }

    @Test
    public void getRecipeCommandByIdTest() throws Exception {
        when(recipeRepository.findById(anyLong())).thenReturn(getOptionalRecipe());
        when(recipeToRecipeCommand.convert(any())).thenReturn(getRecipeCommandData());

        RecipeCommand recipeCommandById = recipeService.findCommandById(1L);

        assertNotNull("Null recipe returned", recipeCommandById);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    private RecipeCommand getRecipeCommandData() {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);
        return recipeCommand;
    }

    @Test
    public void deleteByIdTest() throws Exception {
        // given
        Long idToDelete = 2L;

        // when
        recipeService.deleteById(idToDelete);

        // then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}