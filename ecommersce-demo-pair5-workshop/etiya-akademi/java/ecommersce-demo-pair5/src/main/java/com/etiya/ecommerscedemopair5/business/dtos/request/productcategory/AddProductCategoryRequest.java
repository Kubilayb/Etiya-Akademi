package com.etiya.ecommerscedemopair5.business.dtos.request.productcategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AddProductCategoryRequest {
    private int categoryid;
    private int productid;
    //bunlar maplemek için productId diye yazacağız!!!!!

}
