package com.etiya.ecommercedemopair5.business.dtos.response.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddInvoiceResponse {
    private int id;
    private int orderId;
    private Date orderDate;

}
