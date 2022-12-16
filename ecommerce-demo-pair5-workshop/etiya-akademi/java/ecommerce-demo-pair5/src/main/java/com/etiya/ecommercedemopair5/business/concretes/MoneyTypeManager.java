package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.MoneyTypeService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.moneytype.AddMoneyTypeRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.moneytype.AddMoneyTypeResponse;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.MoneyType;
import com.etiya.ecommercedemopair5.repository.abstracts.MoneyTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class MoneyTypeManager implements MoneyTypeService {

    private MoneyTypeRepository moneyTypeRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<MoneyType>> getAll() {
        List<MoneyType> respones = this.moneyTypeRepository.findAll();
        return new SuccessDataResult<List<MoneyType>>(respones,Messages.MoneyType.getAllMoneyType);
    }

    @Override
    public DataResult<MoneyType> getById(int id) {
        MoneyType response=this.moneyTypeRepository.findById(id).orElseThrow();
        return new SuccessDataResult<MoneyType>(response,Messages.MoneyType.getByMoneyTypeId);
    }

    @Override
    public DataResult<MoneyType> getByName(String name) {
        MoneyType response=this.moneyTypeRepository.findByName(name);
        return new SuccessDataResult<MoneyType>(response,Messages.MoneyType.getByMoneyTypeName);
    }

    @Override
    public Page<MoneyType> findAllWithPagination(Pageable pageable) {
        return moneyTypeRepository.findAll(pageable);
    }

    @Override
    public DataResult<AddMoneyTypeResponse> addMoneyType(AddMoneyTypeRequest addMoneyTypeRequest) {

        MoneyType moneyType =
                modelMapperService.forRequest().map(addMoneyTypeRequest,MoneyType.class);
        AddMoneyTypeResponse addMoneyTypeResponse =
                modelMapperService.forResponse().map(moneyTypeRepository.save(moneyType),AddMoneyTypeResponse.class);
        return new SuccessDataResult<AddMoneyTypeResponse>(addMoneyTypeResponse, Messages.MoneyType.addMoneyType);
    }
}

/*MoneyType moneyType = new MoneyType();
        moneyType.setName(addMoneyTypeRequest.getName());
        //
        // Business Rules
        // Validation
        MoneyType savedMoneyType = moneyTypeRepository.save(moneyType);

        // MAPPING -> Category => AddCategoryResponse
        AddMoneyTypeResponse response =
                new AddMoneyTypeResponse(savedMoneyType.getId(),savedMoneyType.getName());
        return response;*/
