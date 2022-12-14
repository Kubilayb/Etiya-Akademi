package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.payment.AddPaymentRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Payment;

import java.util.List;

public interface PaymentService {

    DataResult<List<Payment>> getAll();
    DataResult<Payment> getById(int id);

    DataResult<AddPaymentResponse> addPayment(AddPaymentRequest addPaymentRequest);

}

