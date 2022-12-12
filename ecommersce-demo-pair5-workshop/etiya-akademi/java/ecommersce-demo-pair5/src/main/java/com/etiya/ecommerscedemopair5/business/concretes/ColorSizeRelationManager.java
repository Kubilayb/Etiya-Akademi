package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.ColorSizeRelationService;
import com.etiya.ecommerscedemopair5.business.dtos.request.colorsizerelation.AddColorSizeRelationRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.colorsizerelation.AddColorSizeRelationResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.entities.concretes.*;
import com.etiya.ecommerscedemopair5.repository.abstracts.ColorSizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorSizeRelationManager implements ColorSizeRelationService {

    private ColorSizeRepository colorSizeRepository;
    /*private SizeService sizeService;
    private ColorService colorService;*/

    private ModelMapperService modelMapperService;

    @Override
    public List<ColorSizeRelation> getAll() {
        return colorSizeRepository.findAll();
    }

    @Override
    public ColorSizeRelation getById(int id) {
        return colorSizeRepository.findById(id).orElseThrow();
    }

    @Override
    public AddColorSizeRelationResponse addColorSizeRelation(AddColorSizeRelationRequest addColorSizeRelationRequest) {
        // MAPPING => AUTO MAPPER

        ColorSizeRelation colorSizeRelation =
                modelMapperService.forRequest().map(addColorSizeRelationRequest,ColorSizeRelation.class);
        AddColorSizeRelationResponse addColorSizeRelationResponse =
                modelMapperService.forResponse().map(colorSizeRepository.save(colorSizeRelation),AddColorSizeRelationResponse.class);
        return addColorSizeRelationResponse;
    }
}
       /* ColorSizeRelation colorSizeRelation = new ColorSizeRelation();

        Color color = colorService.getById(addColorSizeRelationRequest.getColorId());
        colorSizeRelation.setColor(color);

        Size size = sizeService.getById(addColorSizeRelationRequest.getSizeId());
        colorSizeRelation.setSize(size);


        // Business Rules
        // Validation
        ColorSizeRelation savedColorSizeRelation = colorSizeRepository.save(colorSizeRelation);

        // MAPPING -> Category => AddCategoryResponse
        AddColorSizeRelationResponse response =
                new AddColorSizeRelationResponse(savedColorSizeRelation.getId(),
                        savedColorSizeRelation.getColor().getId(),
                        savedColorSizeRelation.getSize().getId());
        return response;*/

