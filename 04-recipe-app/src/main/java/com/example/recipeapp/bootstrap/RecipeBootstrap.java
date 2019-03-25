package com.example.recipeapp.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.recipeapp.domain.Category;
import com.example.recipeapp.domain.Difficulty;
import com.example.recipeapp.domain.Ingredient;
import com.example.recipeapp.domain.Notes;
import com.example.recipeapp.domain.Recipe;
import com.example.recipeapp.domain.UnitOfMeasure;
import com.example.recipeapp.repositories.CategoryRepository;
import com.example.recipeapp.repositories.RecipeRepository;
import com.example.recipeapp.repositories.UnitOfMeasureRepository;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
                           UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipies());
    }

    private List<Recipe> getRecipies() {
        List<Recipe> recipes = new ArrayList<>(2);

        // get UOMs
        UnitOfMeasure eachUom = findAndValidateUomByDescription("Each");
        UnitOfMeasure tableSpoonUom = findAndValidateUomByDescription("Tablespoon");
        UnitOfMeasure teaSpoonUom = findAndValidateUomByDescription("Tablespoon");
        UnitOfMeasure dashUom = findAndValidateUomByDescription("Dash");
        UnitOfMeasure pintUom = findAndValidateUomByDescription("Pint");
        UnitOfMeasure cupUom = findAndValidateUomByDescription("Cup");

        // get Category
        Category americanCategory = findAndValidateCategoryByDescription("American");
        Category mexicanCategory = findAndValidateCategoryByDescription("Mexican");

        // Recipe - Guac
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole...");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("Direction 1");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("Guac Recipe Notes....");
        guacRecipe.setNotes(guacNotes);

        guacRecipe.addIngredient(new Ingredient("Ripe avacados", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(5), teaSpoonUom));
        guacRecipe.addIngredient(new Ingredient("Freash lime juice", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("Ripe tomatoes", new BigDecimal(".5"), eachUom));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        // Recipe - Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Sizzling Tacos...");
        tacosRecipe.setPrepTime(5);
        tacosRecipe.setCookTime(2);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        tacosRecipe.setDirections("Direction 2");

        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("Tacos Recipe Notes...");
        tacosRecipe.setNotes(tacosNotes);

        tacosRecipe.addIngredient(new Ingredient("Ripe avacados", new BigDecimal(2), eachUom));
        tacosRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(5), teaSpoonUom));

        tacosRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);
        recipes.add(tacosRecipe);
        return recipes;
    }

    private Category findAndValidateCategoryByDescription(String description) {
        Optional<Category> categoryOptional = categoryRepository.findByDescription(description);
        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category is not found");
        } else {
            return categoryOptional.get();
        }
    }

    private UnitOfMeasure findAndValidateUomByDescription(String description) {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription(description);
        if (!uomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM is not found");
        } else {
            return uomOptional.get();
        }
    }
}
