package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.ColorService;
import com.etiya.ecommerscedemopair5.business.constants.Messages;
import com.etiya.ecommerscedemopair5.business.dtos.request.colors.AddColorsRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.calors.AddColorsResponse;
import com.etiya.ecommerscedemopair5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Color;
import com.etiya.ecommerscedemopair5.entities.concretes.Size;
import com.etiya.ecommerscedemopair5.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;

    // SAYFALAMA
    // FİLTRELEME

    @Override
    public DataResult<List<Color>> getAll() {
        List<Color> response=this.colorRepository.findAll();
        return new SuccessDataResult<List<Color>>(response, Messages.Color.getAllColors);
    }

    @Override
    public DataResult<Color> getById(int id) {
        Color response = this.colorRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Color>(response,Messages.Color.getByColorId);
    }

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public DataResult<AddColorsResponse> addColor(AddColorsRequest addColorRequest) {
        // MAPPING => AUTO MAPPER
        Color color =
                modelMapperService.forRequest().map(addColorRequest,Color.class);
        AddColorsResponse addColorsResponse =
                modelMapperService.forResponse().map(colorRepository.save(color),AddColorsResponse.class);
        return new SuccessDataResult<AddColorsResponse>(addColorsResponse,Messages.Color.addColor);
    }
}
        /*Color color = new Color();
        color.setName(addColorRequest.getName());

        //
        // Business Rules
        // Validation
        Color savedColor = colorRepository.save(color);

        // MAPPING -> Category => AddCategoryResponse
        AddColorsResponse response =
                new AddColorsResponse(savedColor.getId(), savedColor.getName());
        //
        return response;*/