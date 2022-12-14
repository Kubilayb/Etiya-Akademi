package com.etiya.ecommercedemopair5.business.abstracts;


import com.etiya.ecommercedemopair5.business.dtos.request.addresstitle.AddAddressTittleRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.AddressTitle;

import java.util.List;

public interface AddressTitleService {

    DataResult<List<AddressTitle>> getAll();
    DataResult<AddressTitle> getById(int id);
    DataResult<AddressTitle> getByName(String name);

    DataResult<AddAddressTitleResponse> addAddressTitle(AddAddressTittleRequest addressTitleRequest);
}
