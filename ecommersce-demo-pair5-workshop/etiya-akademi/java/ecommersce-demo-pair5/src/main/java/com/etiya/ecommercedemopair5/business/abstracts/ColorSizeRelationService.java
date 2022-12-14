package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.request.colorsizerelation.AddColorSizeRelationRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.colorsizerelation.AddColorSizeRelationResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.ColorSizeRelation;

import java.util.List;

public interface ColorSizeRelationService {
    DataResult<List<ColorSizeRelation>> getAll();
    DataResult<ColorSizeRelation> getById(int id);

    DataResult<AddColorSizeRelationResponse> addColorSizeRelation(AddColorSizeRelationRequest addColorSizeRelationRequest);

}
