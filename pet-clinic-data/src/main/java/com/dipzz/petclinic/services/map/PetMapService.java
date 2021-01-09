package com.dipzz.petclinic.services.map;

import com.dipzz.petclinic.model.Pet;
import com.dipzz.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
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
        return super.save(object);
    }
}
