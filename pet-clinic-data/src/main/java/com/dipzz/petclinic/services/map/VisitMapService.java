package com.dipzz.petclinic.services.map;

import com.dipzz.petclinic.model.Visit;
import com.dipzz.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {



    @Override
    public Set<Visit> findAll() {
        return super.findALl();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findId(aLong);
    }

    @Override
    public Visit save(Visit visit) {

        if (visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

}
