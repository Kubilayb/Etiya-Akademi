package com.etiya.ecommercedemopair5.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ProductDTO {
    // AllArgs varsa önce id sonra nama yani sırayla
    private int id;
    private String name;

}
