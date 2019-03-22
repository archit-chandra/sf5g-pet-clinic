package com.gemalto.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.gemalto.petclinic.models.PetType;
import com.gemalto.petclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {


    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);
    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
