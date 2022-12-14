package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.request.colors.AddColorsRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.calors.AddColorsResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Color;

import java.util.List;

public interface ColorService {
    DataResult<List<Color>> getAll();
    DataResult<Color> getById(int id);
    DataResult<AddColorsResponse> addColor(AddColorsRequest addColorRequest);

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
}
