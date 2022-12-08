package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.AddressTitleService;
import com.etiya.ecommerscedemopair5.business.dtos.request.addresstitle.AddAddressTittleRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.AddressTitle;
import com.etiya.ecommerscedemopair5.repository.abstracts.AddressTitleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressTitleManager implements AddressTitleService {
    private AddressTitleRepository addressTitleRepository;
    @Override
    public List<AddressTitle> getAll() {
        return addressTitleRepository.findAll();
    }

    @Override
    public AddressTitle getById(int id) {
        return addressTitleRepository.findById(id).orElseThrow();
    }


    @Override
    public AddressTitle getByName(String name) {
        return addressTitleRepository.findByName(name);
    }

    @Override
    public AddAddressTitleResponse addAddressTitle(AddAddressTittleRequest addAddressTitleRequest) {
        // MAPPING => AUTO MAPPER
        AddressTitle addressTitle = new AddressTitle();
        addressTitle.setName(addAddressTitleRequest.getName());

        //
        // Business Rules
        // Validation
        AddressTitle savedAddressTitle = addressTitleRepository.save(addressTitle);

        // MAPPING -> Category => AddCategoryResponse
        AddAddressTitleResponse response =
                new AddAddressTitleResponse(savedAddressTitle.getId(), savedAddressTitle.getName());
        //
        return response;
    }

}
