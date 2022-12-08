package com.etiya.ecommerscedemopair5.business.dtos.response.product;

import com.etiya.ecommerscedemopair5.entities.concretes.ColorSizeRelation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductResponse {
    private int id;
    private String name;
    private double unitPrice;
    private double stock;
    private ColorSizeRelation colorSizeRelation;
}
