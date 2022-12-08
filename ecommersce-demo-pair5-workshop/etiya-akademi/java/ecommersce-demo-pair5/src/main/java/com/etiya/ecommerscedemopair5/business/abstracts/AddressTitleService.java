package com.etiya.ecommerscedemopair5.business.abstracts;


import com.etiya.ecommerscedemopair5.business.dtos.request.addresstitle.AddAddressTittleRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.AddressTitle;

import java.util.List;

public interface AddressTitleService {

    List<AddressTitle> getAll();
    AddressTitle getById(int id);
    AddressTitle getByName(String name);

    AddAddressTitleResponse addAddressTitle(AddAddressTittleRequest addressTitleRequest);
}
