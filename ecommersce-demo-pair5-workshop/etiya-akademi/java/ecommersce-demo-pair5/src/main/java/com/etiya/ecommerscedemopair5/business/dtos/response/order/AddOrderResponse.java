package com.etiya.ecommerscedemopair5.business.dtos.response.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderResponse {
    private int id;
    private java.sql.Date date;
    private int customerId;
    private int addressId;
    private int paymentId;
    private int cargoId;
    private int productId;
}
