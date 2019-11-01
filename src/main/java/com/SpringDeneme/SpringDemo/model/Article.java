package com.SpringDeneme.SpringDemo.model;

import com.SpringDeneme.SpringDemo.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Article {
    @Id
    int id;
    private Category category;
    private String email;

    @JsonIgnore
    private String mySecret;

    @JsonIgnoreProperties({"myIdSecret"})
    private String mySecretProperties;

}
