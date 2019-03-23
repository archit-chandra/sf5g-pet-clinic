package com.gemalto.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gemalto.petclinic.models.Owner;
import com.gemalto.petclinic.models.PetType;
import com.gemalto.petclinic.models.Vet;
import com.gemalto.petclinic.services.OwnerService;
import com.gemalto.petclinic.services.PetTypeService;
import com.gemalto.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner("Michael", "Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner("Fionna", "Glenanne");
        ownerService.save(owner2);

        System.out.println("========>>>> Loaded Owners");

        Vet vet1 = new Vet("Sam", "Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet("Jessie", "Porter");
        vetService.save(vet2);

        System.out.println("========>>>> Loaded Vets");
    }
}
