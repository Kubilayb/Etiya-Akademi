package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.request.moneytype.AddMoneyTypeRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.moneytype.AddMoneyTypeResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.MoneyType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MoneyTypeService {

    DataResult<List<MoneyType>> getAll();
    DataResult<MoneyType> getById(int id);

    DataResult<MoneyType> getByName(String name);
    Page<MoneyType> findAllWithPagination(Pageable pageable);

    DataResult<AddMoneyTypeResponse> addMoneyType(AddMoneyTypeRequest addMoneyTypeRequest);
}
