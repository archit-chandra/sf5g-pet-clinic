package com.gemalto.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gemalto.petclinic.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
