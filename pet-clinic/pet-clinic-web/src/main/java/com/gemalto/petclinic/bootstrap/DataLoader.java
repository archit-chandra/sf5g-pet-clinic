package com.gemalto.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gemalto.petclinic.models.Owner;
import com.gemalto.petclinic.models.Vet;
import com.gemalto.petclinic.services.OwnerService;
import com.gemalto.petclinic.services.VetService;
import com.gemalto.petclinic.services.map.OwnerServiceMap;
import com.gemalto.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner("Michael", "Weston");
        owner1.setId(1L);
        ownerService.save(owner1);

        Owner owner2 = new Owner("Fionna", "Glenanne");
        owner2.setId(2L);
        ownerService.save(owner2);

        System.out.println("========>>>> Loaded Owners");

        Vet vet1 = new Vet("Sam", "Axe");
        vet1.setId(1L);
        vetService.save(vet1);

        Vet vet2 = new Vet("Jessie", "Porter");
        vet2.setId(2L);
        vetService.save(vet2);

        System.out.println("========>>>> Loaded Vets");
    }
}
