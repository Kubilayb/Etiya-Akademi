package com.etiya.ecommercedemopair5.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "addressid")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "paymentid")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "cargoid")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    @OneToOne(mappedBy = "order")
    @JsonIgnore
    private Invoice invoice;


}
