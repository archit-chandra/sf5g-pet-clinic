package com.gemalto.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gemalto.petclinic.models.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
