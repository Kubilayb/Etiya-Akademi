package com.etiya.ecommerscedemopair5.business.dtos.response.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AddPaymentResponse {
    private int id;
    private int moneyTypeId;
}
