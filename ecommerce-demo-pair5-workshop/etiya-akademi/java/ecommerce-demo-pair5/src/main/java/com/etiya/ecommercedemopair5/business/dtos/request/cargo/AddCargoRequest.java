package com.etiya.ecommercedemopair5.business.dtos.request.cargo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddCargoRequest {
    private String name;
    private int price;
}
