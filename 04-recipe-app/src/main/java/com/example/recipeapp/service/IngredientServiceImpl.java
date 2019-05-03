package com.example.recipeapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.recipeapp.commands.IngredientCommand;
import com.example.recipeapp.converters.IngredientToIngredientCommand;
import com.example.recipeapp.domain.Recipe;
import com.example.recipeapp.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if (!recipeOptional.isPresent()) {
            //TODO: impl error handling
            log.error("recipe id not found. Id: " + recipeId);
            return null;
        }
        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();
        //below can be used too instead of lambda
        //.map(ingredientToIngredientCommand::convert).findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            //TODO: impl error handling
            log.error("Ingredient id not found: " + ingredientId);
            return null;
        }

        return ingredientCommandOptional.get();
    }
}
