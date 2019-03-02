package com.gemalto.petclinic.services;

import java.util.Set;

import com.gemalto.petclinic.models.Vet;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
