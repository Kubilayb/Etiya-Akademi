package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.AddressDTO;
import com.etiya.ecommercedemopair5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {

    DataResult<List<Address>> getAll();

    DataResult<Address> getById(int id);

    DataResult<List<Address>> getByName(String street);

    DataResult<List<AddressDTO>> findByAddressExample(int id);
    Page<Address> findAllWithPagination(Pageable pageable);
/*
    List<Address> customAddress(int id);
*/
    DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest);

}
