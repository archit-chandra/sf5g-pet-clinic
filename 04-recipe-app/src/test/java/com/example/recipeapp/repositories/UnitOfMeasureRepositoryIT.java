package com.example.recipeapp.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.recipeapp.domain.UnitOfMeasure;

// running with spring context
@RunWith(SpringRunner.class)

// for embedded database
// configure spring data jpa
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        uomOptional.ifPresent(unitOfMeasure -> assertEquals("Teaspoon", unitOfMeasure.getDescription()));
    }

    @Test
    public void findByDescriptionCup() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
        uomOptional.ifPresent(unitOfMeasure -> assertEquals("Cup", unitOfMeasure.getDescription()));
    }
}