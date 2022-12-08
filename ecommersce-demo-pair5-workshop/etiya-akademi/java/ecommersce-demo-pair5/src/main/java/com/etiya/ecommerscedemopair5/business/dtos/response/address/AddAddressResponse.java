package com.etiya.ecommerscedemopair5.business.dtos.response.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddAddressResponse {
    private int id;
    private int addresstitleId;
    private int cityId;
    private String street;
    private int customerId;

}
