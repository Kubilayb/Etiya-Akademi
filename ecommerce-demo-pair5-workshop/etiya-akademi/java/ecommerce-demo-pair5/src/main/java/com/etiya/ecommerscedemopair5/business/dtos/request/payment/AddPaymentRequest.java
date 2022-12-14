package com.etiya.ecommerscedemopair5.business.dtos.request.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AddPaymentRequest {
    private int moneyTypeId;
}
