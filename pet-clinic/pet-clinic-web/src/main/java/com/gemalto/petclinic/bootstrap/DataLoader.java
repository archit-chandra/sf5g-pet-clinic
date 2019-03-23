package com.gemalto.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gemalto.petclinic.models.Owner;
import com.gemalto.petclinic.models.Pet;
import com.gemalto.petclinic.models.PetType;
import com.gemalto.petclinic.models.Speciality;
import com.gemalto.petclinic.models.Vet;
import com.gemalto.petclinic.services.OwnerService;
import com.gemalto.petclinic.services.PetTypeService;
import com.gemalto.petclinic.services.SpecialityService;
import com.gemalto.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        /////////////// Pet types ////////////////////////////
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        /////////////// Pet types - end //////////////////////

        /////////////// Specialities ////////////////////////////
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);
        /////////////// Specialities - end //////////////////////

        Owner owner1 = new Owner("Michael", "Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("New York");
        owner1.setTelephone("1234567890");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        addPetsToOwners(owner1, savedDogPetType, mikesPet);

        Owner owner2 = new Owner("Fionna", "Glenanne");
        owner2.setAddress("Paul Valinterre");
        owner2.setCity("Paris");
        owner2.setTelephone("7510532040");

        Pet fionanPet = new Pet();
        fionanPet.setName("Jackie");
        addPetsToOwners(owner2, savedCatPetType, fionanPet);

        System.out.println("========>>>> Loaded Owners");

        Vet vet1 = new Vet("Sam", "Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet("Jessie", "Porter");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("========>>>> Loaded Vets");
    }

    private void addPetsToOwners(Owner owner, PetType petType, Pet pet) {
        pet.setPetType(petType);
        pet.setOwner(owner);
        pet.setBirthDate(LocalDate.now());
        owner.getPets().add(pet);
        ownerService.save(owner);
    }
}
