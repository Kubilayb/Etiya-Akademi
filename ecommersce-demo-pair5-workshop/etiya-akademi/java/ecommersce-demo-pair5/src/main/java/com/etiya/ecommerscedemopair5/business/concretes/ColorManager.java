package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.ColorService;
import com.etiya.ecommerscedemopair5.business.dtos.request.colors.AddColorsRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.calors.AddColorsResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Color;
import com.etiya.ecommerscedemopair5.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        // SAYFALAMA
        // FİLTRELEME
        return colorRepository.findAll();
    }

    @Override
    public Color getById(int id) {
        return colorRepository.findById(id).orElseThrow();
    }

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public AddColorsResponse addColor(AddColorsRequest addColorRequest) {
        // MAPPING => AUTO MAPPER
        Color color = new Color();
        color.setName(addColorRequest.getName());

        //
        // Business Rules
        // Validation
        Color savedColor = colorRepository.save(color);

        // MAPPING -> Category => AddCategoryResponse
        AddColorsResponse response =
                new AddColorsResponse(savedColor.getId(), savedColor.getName());
        //
        return response;
    }
}
