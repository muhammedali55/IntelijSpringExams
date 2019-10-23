package com.SpringDeneme.SpringDemo.service;

import com.SpringDeneme.SpringDemo.exception.OwnerNotFoundException;
import com.SpringDeneme.SpringDemo.model.Owner;

import java.util.List;

public interface PetClinicService {

    List<Owner> findOwners();
    List<Owner> findOwners(String lastName);
    Owner findOwner(Long id) throws OwnerNotFoundException;
    void createOwner(Owner owner);
    void updateOwner(Owner owner);
    void deleteOwner(Long id);

}
