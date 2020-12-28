package com.dipzz.petclinic.services.map;

import com.dipzz.petclinic.model.Pet;
import com.dipzz.petclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findALl();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findId(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }
}
