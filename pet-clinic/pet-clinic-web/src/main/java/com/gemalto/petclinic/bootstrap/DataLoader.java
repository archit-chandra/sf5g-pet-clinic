package com.gemalto.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gemalto.petclinic.models.Owner;
import com.gemalto.petclinic.models.Vet;
import com.gemalto.petclinic.services.OwnerService;
import com.gemalto.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
