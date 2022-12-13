package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.AddressTitleService;
import com.etiya.ecommerscedemopair5.business.constants.Messages;
import com.etiya.ecommerscedemopair5.business.dtos.request.addresstitle.AddAddressTittleRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.AddressTitle;
import com.etiya.ecommerscedemopair5.repository.abstracts.AddressTitleRepository;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.modelmapper.internal.util.Stack;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressTitleManager implements AddressTitleService {
    private AddressTitleRepository addressTitleRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<AddressTitle>> getAll() {
        List<AddressTitle> response= this.addressTitleRepository.findAll();
        return new SuccessDataResult<List<AddressTitle>>(response,Messages.AddressTitle.getAllStreets);
    }

    @Override
    public DataResult<AddressTitle> getById(int id) {
        AddressTitle response = this.addressTitleRepository.findById(id).orElseThrow();
        return new SuccessDataResult<AddressTitle>(response,Messages.AddressTitle.getByStreetId);
    }


    @Override
    public DataResult<AddressTitle> getByName(String name) {
        AddressTitle response = this.addressTitleRepository.findByName(name);
        return new SuccessDataResult<AddressTitle>(response,Messages.AddressTitle.getByStreetName);
    }

    @Override
    public DataResult<AddAddressTitleResponse> addAddressTitle(AddAddressTittleRequest addAddressTitleRequest) {
        // MAPPING => AUTO MAPPER
        AddressTitle addressTitle =
                modelMapperService.forRequest().map(addAddressTitleRequest,AddressTitle.class);
        AddAddressTitleResponse addAddressTitleResponse=
                modelMapperService.getMapper().map(addressTitleRepository.save(addressTitle),AddAddressTitleResponse.class);
        return new SuccessDataResult<AddAddressTitleResponse>(addAddressTitleResponse,Messages.AddressTitle.addStreet);

    }
}
/* AddressTitle addressTitle = new AddressTitle();
        addressTitle.setName(addAddressTitleRequest.getName());

        //
        // Business Rules
        // Validation
        AddressTitle savedAddressTitle = addressTitleRepository.save(addressTitle);

        // MAPPING -> Category => AddCategoryResponse
        AddAddressTitleResponse response =
                new AddAddressTitleResponse(savedAddressTitle.getId(), savedAddressTitle.getName());
        //
        return response;*/