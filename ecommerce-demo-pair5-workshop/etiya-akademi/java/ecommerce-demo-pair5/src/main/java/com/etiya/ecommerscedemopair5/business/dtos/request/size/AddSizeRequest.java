package com.etiya.ecommerscedemopair5.business.dtos.request.size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
public class AddSizeRequest {

    private String name;
    private int stock;
}
