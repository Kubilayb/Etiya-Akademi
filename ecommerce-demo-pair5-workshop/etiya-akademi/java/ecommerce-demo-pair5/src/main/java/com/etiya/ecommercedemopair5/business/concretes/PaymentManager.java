package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.PaymentService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.payment.AddPaymentRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommercedemopair5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Payment;
import com.etiya.ecommercedemopair5.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;
    private MessageSource messageSource;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<Payment>> getAll() {
        List<Payment> response = this.paymentRepository.findAll();
        return new SuccessDataResult<List<Payment>>(response, Messages.Payment.getAllPayment);
    }

    @Override
    public DataResult<Payment> getById(int id) {
        Payment response = this.paymentRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Payment>(response,Messages.Payment.getByPaymentId);
    }

    @Override
    public Page<Payment> findAllWithPagination(Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }

    @Override
    public DataResult<AddPaymentResponse> addPayment(AddPaymentRequest addPaymentRequest) {


        // MAPPING => AUTO MAPPER

        Payment payment =
                modelMapperService.forRequest().map(addPaymentRequest,Payment.class);
        AddPaymentResponse addPaymentResponse =
                modelMapperService.forResponse().map(paymentRepository.save(payment),AddPaymentResponse.class);
        return new SuccessDataResult<AddPaymentResponse>(addPaymentResponse,Messages.Payment.addPayment);
    }


}
    /*Payment payment = new Payment();
    MoneyType moneyType = moneyTypeService.getById(addPaymentRequest.getMoneytypeid());
        payment.setMoneyType(moneyType);

                //
                // Business Rules
                // Validation
                Payment savedPayment = paymentRepository.save(payment);

                // MAPPING -> Category => AddCategoryResponse
                AddPaymentResponse response =
                new AddPaymentResponse(savedPayment.getId(),savedPayment.getMoneyType().getId());
                return response;*/