package com.etiya.ecommercedemopair5.business.dtos.request.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AddPaymentRequest {
    private int moneyTypeId;
}
