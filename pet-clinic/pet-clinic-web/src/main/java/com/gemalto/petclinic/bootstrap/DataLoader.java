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
import com.gemalto.petclinic.models.Visit;
import com.gemalto.petclinic.services.OwnerService;
import com.gemalto.petclinic.services.PetTypeService;
import com.gemalto.petclinic.services.SpecialityService;
import com.gemalto.petclinic.services.VetService;
import com.gemalto.petclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int petCounts = petTypeService.findAll().size();
        if (petCounts == 0) {
            loadData();
        }
    }

    private void loadData() {

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

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("New York");
        owner1.setTelephone("1234567890");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        addPetsToOwners(owner1, savedDogPetType, mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenanne");
        owner2.setAddress("Paul Valinterre");
        owner2.setCity("Paris");
        owner2.setTelephone("7510532040");

        Pet fionnaPet = new Pet();
        fionnaPet.setName("Jackie");
        addPetsToOwners(owner2, savedCatPetType, fionnaPet);

        Visit catVisit = new Visit();
        catVisit.setPet(fionnaPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        System.out.println("========>>>> Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
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
