package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.size.AddSizeRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Size;

import java.util.List;


public interface SizeService {
    DataResult<List<Size>> getAllByStockGreaterThan(int stock);

    DataResult<List<Size>> getAll();

    DataResult<Size> getById(int id);

    DataResult<Size> getByName(String name);

    DataResult<AddSizeResponse> addSize(AddSizeRequest addSizeRequest);
}
