package com.etiya.ecommercedemopair5.business.dtos.response.size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddSizeResponse {
    private int id;
    private String name;
    private int stock;
}
