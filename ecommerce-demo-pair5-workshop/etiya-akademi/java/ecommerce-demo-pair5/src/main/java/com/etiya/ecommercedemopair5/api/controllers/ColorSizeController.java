package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.business.abstracts.ColorSizeRelationService;
import com.etiya.ecommercedemopair5.business.dtos.request.colorsizerelation.AddColorSizeRelationRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.colorsizerelation.AddColorSizeRelationResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.ColorSizeRelation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/app/colorsizerelations")
public class ColorSizeController {
    private ColorSizeRelationService colorSizeRelationService;

    // GetCategoryResponse => id,name
    @GetMapping("/getAll")
    public DataResult<List<ColorSizeRelation>> getAll(){
        return colorSizeRelationService.getAll();
    }

    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddColorSizeRelationResponse>> addColorSizeRelation(@RequestBody AddColorSizeRelationRequest addColorSizeRelationRequest){
        return new ResponseEntity<DataResult<AddColorSizeRelationResponse>>(colorSizeRelationService.addColorSizeRelation(addColorSizeRelationRequest), HttpStatus.CREATED);
    }

    @GetMapping("getWithPagination")
    // RequestParam => page, pageSize
    public Page<ColorSizeRelation> getWithPagination(@RequestParam("page")int page, @RequestParam("pageSize")int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        return colorSizeRelationService.findAllWithPagination(pageable);
    }
}
