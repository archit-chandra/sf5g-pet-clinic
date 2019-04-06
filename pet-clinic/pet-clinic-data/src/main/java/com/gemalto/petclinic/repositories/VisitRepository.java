package com.gemalto.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gemalto.petclinic.models.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
