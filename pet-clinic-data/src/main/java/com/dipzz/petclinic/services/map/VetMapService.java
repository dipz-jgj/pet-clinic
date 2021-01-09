package com.dipzz.petclinic.services.map;

import com.dipzz.petclinic.model.Speciality;
import com.dipzz.petclinic.model.Vet;
import com.dipzz.petclinic.services.SpecialityService;
import com.dipzz.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findALl();
    }

    @Override
    public Vet findById(Long id) {
        return super.findId(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
