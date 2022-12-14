package com.etiya.ecommercedemopair5.business.dtos.request.product;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    private String name;
    @Min(value=1,message = "Ürün değeri  1'den küçük olamaz.")
    private double unitPrice;
    @Min(value = 0,message = "Stok adeti 0'dan küçük olamaz")
    //stock 0 olamaz(validasyon)
    private double stock;
    @Positive(message = "Colorsizeid positive olmalıdır!")
    private int colorSizeId;

}
// name boş bırakılamaz (validasyon) iki tane var null blank
//@NotNull(message = "Ürün ismi boş olamaz.")
//    @NotBlank(message = "Ürün ismi boş olamaz.")
//