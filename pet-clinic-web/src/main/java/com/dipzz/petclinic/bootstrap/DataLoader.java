package com.dipzz.petclinic.bootstrap;

import com.dipzz.petclinic.model.*;
import com.dipzz.petclinic.services.*;
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
    private final SpecialityService specialityService;
    private final VisitService visitService;

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
        int count = petTypeService.findAll().size();

        if (count == 0)
            loadData();
    }

    private void loadData() {
        // Create PetType Data
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        // Create Vet Specialities Data
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        specialityService.save(dentistry);

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

        // add visit data
        Visit catVisit = new Visit();
        catVisit.setPet(jerry);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Cat");

        visitService.save(catVisit);

        System.out.println("Loaded owner...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Fisher");
        vet2.getSpecialties().add(surgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
