package com.gemalto.petclinic.services;

import com.gemalto.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
