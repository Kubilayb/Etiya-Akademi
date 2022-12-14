package com.etiya.ecommercedemopair5.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cargo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "price")
    private int price;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cargo")
    @JsonIgnore
    private List<Order> orders;


}
