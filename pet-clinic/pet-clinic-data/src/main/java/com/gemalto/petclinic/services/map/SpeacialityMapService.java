package com.gemalto.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.gemalto.petclinic.models.Speciality;
import com.gemalto.petclinic.services.SpecialityService;

@Service
public class SpeacialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
