package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.AddressTitleService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.addresstitle.AddAddressTittleRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommercedemopair5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.AddressTitle;
import com.etiya.ecommercedemopair5.entities.concretes.Product;
import com.etiya.ecommercedemopair5.repository.abstracts.AddressTitleRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressTitleManager implements AddressTitleService {
    private AddressTitleRepository addressTitleRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

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
    public Page<AddressTitle> findAllWithPagination(Pageable pageable) {
        return addressTitleRepository.findAll(pageable);
    }

    @Override
    public DataResult<AddAddressTitleResponse> addAddressTitle(AddAddressTittleRequest addAddressTitleRequest) {

        addressTitleCanNotExistWithSameName(addAddressTitleRequest.getName());


        // MAPPING => AUTO MAPPER
        AddressTitle addressTitle =
                modelMapperService.forRequest().map(addAddressTitleRequest,AddressTitle.class);
        AddAddressTitleResponse addAddressTitleResponse=
                modelMapperService.getMapper().map(addressTitleRepository.save(addressTitle),AddAddressTitleResponse.class);
        return new SuccessDataResult<AddAddressTitleResponse>(addAddressTitleResponse,Messages.AddressTitle.addStreet);

    }
    private void addressTitleCanNotExistWithSameName(String name) {
        boolean isExists = addressTitleRepository.existsAddressTitleByName(name);
        if (isExists) // Veritabanımda bu isimde bir adres başlığı mevcut!!
            throw new BusinessException(messageSource.getMessage
                    (Messages.AddressTitle.AddressTitleExistsWithSameName,null,LocaleContextHolder.getLocale()));

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