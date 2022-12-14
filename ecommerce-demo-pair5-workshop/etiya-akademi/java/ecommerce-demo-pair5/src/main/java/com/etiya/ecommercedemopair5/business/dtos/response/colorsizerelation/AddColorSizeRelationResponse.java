package com.etiya.ecommercedemopair5.business.dtos.response.colorsizerelation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddColorSizeRelationResponse {
    private int id;
    private int sizeId;
    private int colorId;
}
