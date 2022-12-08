package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.MoneyTypeService;
import com.etiya.ecommerscedemopair5.business.dtos.request.moneytype.AddMoneyTypeRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.moneytype.AddMoneyTypeResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.MoneyType;
import com.etiya.ecommerscedemopair5.repository.abstracts.MoneyTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class MoneyTypeManager implements MoneyTypeService {

    private MoneyTypeRepository moneyTypeRepository;
    @Override
    public List<MoneyType> getAll() {
        return null;
    }

    @Override
    public MoneyType getById(int id) {
        return moneyTypeRepository.findById(id).orElseThrow();
    }

    @Override
    public MoneyType getByName(String name) {
        return moneyTypeRepository.findByName(name);
    }

    @Override
    public AddMoneyTypeResponse addMoneyType(AddMoneyTypeRequest addMoneyTypeRequest) {
        MoneyType moneyType = new MoneyType();
        moneyType.setName(addMoneyTypeRequest.getName());


        //
        // Business Rules
        // Validation
        MoneyType savedMoneyType = moneyTypeRepository.save(moneyType);

        // MAPPING -> Category => AddCategoryResponse
        AddMoneyTypeResponse response =
                new AddMoneyTypeResponse(savedMoneyType.getId(),savedMoneyType.getName());
        return response;
    }
}


