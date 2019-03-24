package com.example.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
