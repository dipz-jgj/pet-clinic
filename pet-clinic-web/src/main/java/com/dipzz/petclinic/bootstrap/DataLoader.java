package com.dipzz.petclinic.bootstrap;

import com.dipzz.petclinic.model.Owner;
import com.dipzz.petclinic.model.Pet;
import com.dipzz.petclinic.model.PetType;
import com.dipzz.petclinic.model.Vet;
import com.dipzz.petclinic.services.OwnerService;
import com.dipzz.petclinic.services.PetTypeService;
import com.dipzz.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Load data on startup
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("323 Street");
        owner1.setCity("Los Angeles");
        owner1.setTelephone("444323");

        Pet snowy = new Pet();
        snowy.setName("Snowy");
        snowy.setPetType(saveDogPetType);
        snowy.setOwner(owner1);
        snowy.setBirthDate(LocalDate.now());
        owner1.getPets().add(snowy);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("M");
        owner2.setAddress("212 Street");
        owner2.setCity("San Diego");
        owner2.setTelephone("565743");

        Pet jerry = new Pet();
        jerry.setName("Jerry");
        jerry.setPetType(saveCatPetType);
        jerry.setOwner(owner2);
        jerry.setBirthDate(LocalDate.now());
        owner2.getPets().add(jerry);

        ownerService.save(owner2);

        System.out.println("Loaded owner...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Fisher");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
