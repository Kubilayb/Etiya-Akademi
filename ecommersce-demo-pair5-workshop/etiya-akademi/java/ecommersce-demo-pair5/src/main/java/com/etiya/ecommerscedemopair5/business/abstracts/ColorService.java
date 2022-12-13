package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.colors.AddColorsRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.calors.AddColorsResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Color;

import java.util.List;

public interface ColorService {
    DataResult<List<Color>> getAll();
    DataResult<Color> getById(int id);
    DataResult<AddColorsResponse> addColor(AddColorsRequest addColorRequest);

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
}
