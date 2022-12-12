package com.etiya.ecommerscedemopair5.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street")
    private String street;

    @ManyToOne
    @JoinColumn(name = "addresstitleid")
    private AddressTitle addresstitle;

    @ManyToOne
    @JoinColumn(name = "cityid")
    private City city;

    @ManyToOne
    @JoinColumn(name = "customerid")
   // @JsonIgnoreProperties("address")
    private Customer customers;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<Order> orders;

}


