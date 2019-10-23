package com.SpringDeneme.SpringDemo.dao.mem;

import com.SpringDeneme.SpringDemo.dao.OwnerRepository;
import com.SpringDeneme.SpringDemo.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OwnerRepositoryInMemoryImpl implements OwnerRepository {

    private Map<Long,Owner> ownersMap = new HashMap<>();

    public OwnerRepositoryInMemoryImpl(){
        Owner owner;

        owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Muhammet Ali");
        owner.setLastName("Soyad");
        ownersMap.put(1L,owner);

        owner = new Owner();
        owner.setId(2L);
        owner.setFirstName("Veli");
        owner.setLastName("Soyad2");
        ownersMap.put(2L,owner);

        owner = new Owner();
        owner.setId(3L);
        owner.setFirstName("Canan");
        owner.setLastName("Soyad-3");
        ownersMap.put(3L,owner);

        owner = new Owner();
        owner.setId(4L);
        owner.setFirstName("Tuba");
        owner.setLastName("Soyad-4");
        ownersMap.put(4L,owner);


    }

    @Override
    public List<Owner> findAll() {
        return null;
    }

    @Override
    public Owner findById(Long id) {
        return null;
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return null;
    }

    @Override
    public void create(Owner owner) {

    }

    @Override
    public Owner update(Owner owner) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
