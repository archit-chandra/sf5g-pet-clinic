package com.example.recipeapp.controllers;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.example.recipeapp.domain.Recipe;
import com.example.recipeapp.service.RecipeService;

public class HomeControllerTest {

    private HomeController homeController;

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        homeController = new HomeController(recipeService);
    }

    @Test
    public void getHomePage() {
        when(recipeService.getRecipes()).thenReturn(getRecipeData());
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = homeController.getHomePage(model);
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }

    private Set<Recipe> getRecipeData() {
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe1.setId(2L);

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        return recipes;
    }
}