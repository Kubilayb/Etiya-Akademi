package com.etiya.ecommerscedemopair5.api.controllers;

import com.etiya.ecommerscedemopair5.business.abstracts.ColorService;
import com.etiya.ecommerscedemopair5.business.dtos.request.colors.AddColorsRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.calors.AddColorsResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Color;
import com.etiya.ecommerscedemopair5.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color")
@AllArgsConstructor
public class ColorController {
    private ColorService colorService;

    @GetMapping("/getAll")
    public DataResult<List<Color>> getAll(){
        return colorService.getAll();
    }

    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddColorsResponse>> addColor(@RequestBody AddColorsRequest addColorRequest){
        return new ResponseEntity<DataResult<AddColorsResponse>>(colorService.addColor(addColorRequest), HttpStatus.CREATED);
    }
}