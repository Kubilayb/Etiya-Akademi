package com.etiya.ecommercedemopair5.business.dtos.response.cargo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class AddCargoResponse {
    private int id;
    private String name;
    private int price;

}
