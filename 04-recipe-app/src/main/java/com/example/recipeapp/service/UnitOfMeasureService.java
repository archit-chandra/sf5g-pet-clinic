package com.example.recipeapp.service;

import java.util.Set;

import com.example.recipeapp.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
