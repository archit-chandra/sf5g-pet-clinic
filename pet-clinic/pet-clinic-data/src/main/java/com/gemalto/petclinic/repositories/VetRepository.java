package com.gemalto.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gemalto.petclinic.models.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
