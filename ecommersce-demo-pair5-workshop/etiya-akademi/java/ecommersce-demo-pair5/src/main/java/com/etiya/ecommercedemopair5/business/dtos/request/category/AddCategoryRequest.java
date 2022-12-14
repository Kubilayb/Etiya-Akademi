package com.etiya.ecommercedemopair5.business.dtos.request.category;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AddCategoryRequest {

    @NotNull(message = "Kategori ismi boş olamaz.")
    @NotBlank(message = "Kategori ismi boş olamaz.")
    @Size(min = 3,max = 20,message = "Lütfen Yeterli Karakter Giriniz.")
    private String name;

    private String type;
}
