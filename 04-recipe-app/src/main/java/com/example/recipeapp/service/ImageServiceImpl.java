package com.example.recipeapp.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.recipeapp.domain.Recipe;
import com.example.recipeapp.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeService) {

        this.recipeRepository = recipeService;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {

        try {
            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;
            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
            if (recipeOptional.isPresent()) {
                Recipe recipe = recipeOptional.get();
                recipe.setImage(byteObjects);
                recipeRepository.save(recipe);
            } else {
                log.error("Recipe not found for recipeId:'{}'", recipeId);
            }

        } catch (IOException e) {
            // TODO:
            //  handle exception better
            log.error("Error occurred", e);
            e.printStackTrace();
        }
    }
}
