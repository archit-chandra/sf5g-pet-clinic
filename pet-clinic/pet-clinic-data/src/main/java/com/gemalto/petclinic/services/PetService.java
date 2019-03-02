package com.gemalto.petclinic.services;

import java.util.Set;

import com.gemalto.petclinic.models.Pet;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
