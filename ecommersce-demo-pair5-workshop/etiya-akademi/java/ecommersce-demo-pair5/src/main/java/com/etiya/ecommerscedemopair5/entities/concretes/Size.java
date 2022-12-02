package com.etiya.ecommerscedemopair5.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "size")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Size {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    @OneToMany(mappedBy = "size")
    @JsonIgnore
    private List<ColorSizeRelation> colorSizeRelations;
}
