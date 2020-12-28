package com.dipzz.petclinic.services.map;

import com.dipzz.petclinic.model.Vet;
import com.dipzz.petclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findALl();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findId(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }
}
