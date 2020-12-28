package com.dipzz.petclinic.services;

import com.dipzz.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}
