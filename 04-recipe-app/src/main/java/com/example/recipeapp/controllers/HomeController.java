package com.example.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.recipeapp.service.RecipeService;

@Controller
public class HomeController {

    private final RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "index", "index.html"})
    public String getHomePage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
