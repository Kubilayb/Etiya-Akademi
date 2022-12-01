package com.etiya.ecommerscedemopair5.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")

public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category" )
    @JsonIgnore
    private List<ProductCategory> productCategories;
}
