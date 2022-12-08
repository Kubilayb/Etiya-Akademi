package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.MoneyTypeService;
import com.etiya.ecommerscedemopair5.business.abstracts.PaymentService;
import com.etiya.ecommerscedemopair5.business.dtos.request.payment.AddPaymentRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommerscedemopair5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.MoneyType;
import com.etiya.ecommerscedemopair5.entities.concretes.Payment;
import com.etiya.ecommerscedemopair5.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {


    private PaymentRepository paymentRepository;

    private MoneyTypeService moneyTypeService;
    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(int id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    @Override
    public AddPaymentResponse addPayment(AddPaymentRequest addPaymentRequest) {
        // MAPPING => AUTO MAPPER
        Payment payment = new Payment();
        MoneyType moneyType = moneyTypeService.getById(addPaymentRequest.getMoneytypeid());
        payment.setMoneyType(moneyType);

        //
        // Business Rules
        // Validation
        Payment savedPayment = paymentRepository.save(payment);

        // MAPPING -> Category => AddCategoryResponse
        AddPaymentResponse response =
                new AddPaymentResponse(savedPayment.getId(),savedPayment.getMoneyType().getId());
        return response;
    }

}
