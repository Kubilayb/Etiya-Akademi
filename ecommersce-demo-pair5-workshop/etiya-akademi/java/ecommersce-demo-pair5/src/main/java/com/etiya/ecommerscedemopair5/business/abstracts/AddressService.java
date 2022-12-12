package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.AddressDTO;
import com.etiya.ecommerscedemopair5.business.dtos.CategoryDTO;
import com.etiya.ecommerscedemopair5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll();

    Address getById(int id);

    List<Address> getByName(String street);

    DataResult<List<AddressDTO>> findByAddressExample(int id);

    AddAddressResponse addAddress(AddAddressRequest addAddressRequest);

}
