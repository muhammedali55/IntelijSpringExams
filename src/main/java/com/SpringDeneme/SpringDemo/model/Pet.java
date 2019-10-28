package com.SpringDeneme.SpringDemo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Pet {

    @Id
    @SequenceGenerator(name = "sq_pet_id",sequenceName = "sq_pet_id",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "sq_pet_id")
    private Long id;
    private String name;
    private Date birthDate;

    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private Owner owner;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    @Override
    public String toString() {
        return "Pet [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", owner=" + owner + "]";
    }
}
