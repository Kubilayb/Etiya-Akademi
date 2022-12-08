package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.moneytype.AddMoneyTypeRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.moneytype.AddMoneyTypeResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.MoneyType;

import java.util.List;

public interface MoneyTypeService {

    List<MoneyType> getAll();
    MoneyType getById(int id);

    MoneyType getByName(String name);

    AddMoneyTypeResponse addMoneyType(AddMoneyTypeRequest addMoneyTypeRequest);
}
