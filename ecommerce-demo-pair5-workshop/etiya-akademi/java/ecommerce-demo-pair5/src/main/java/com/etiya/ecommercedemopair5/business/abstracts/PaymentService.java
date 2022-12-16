package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.request.payment.AddPaymentRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {

    DataResult<List<Payment>> getAll();
    DataResult<Payment> getById(int id);

    DataResult<AddPaymentResponse> addPayment(AddPaymentRequest addPaymentRequest);

    Page<Payment> findAllWithPagination(Pageable pageable);
}

