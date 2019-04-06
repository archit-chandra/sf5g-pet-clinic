package com.gemalto.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gemalto.petclinic.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
