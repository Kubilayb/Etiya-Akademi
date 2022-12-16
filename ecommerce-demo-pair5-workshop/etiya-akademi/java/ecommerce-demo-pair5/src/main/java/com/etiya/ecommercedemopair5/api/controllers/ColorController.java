package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.business.abstracts.ColorService;
import com.etiya.ecommercedemopair5.business.dtos.request.colors.AddColorsRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.colors.AddColorsResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Color;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("getWithPagination")
    // RequestParam => page, pageSize
    public Page<Color> getWithPagination(@RequestParam("page")int page, @RequestParam("pageSize")int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        return colorService.findAllWithPagination(pageable);
    }
}