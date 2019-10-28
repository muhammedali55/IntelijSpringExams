package com.SpringDeneme.SpringDemo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Owner {
    @Id
    @SequenceGenerator(name = "sq_owner_id",sequenceName = "sq_owner_id",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "sq_owner_id")
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
