package com.example.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.recipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
