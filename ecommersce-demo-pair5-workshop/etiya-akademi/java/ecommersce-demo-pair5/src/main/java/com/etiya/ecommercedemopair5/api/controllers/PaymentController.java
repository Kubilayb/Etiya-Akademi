package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.business.abstracts.PaymentService;
import com.etiya.ecommercedemopair5.business.dtos.request.payment.AddPaymentRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Payment>> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Payment> getById(@RequestParam("id") int id){
        return paymentService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddPaymentResponse>> addPayment(@RequestBody AddPaymentRequest addPaymentRequest){
        return new ResponseEntity<DataResult<AddPaymentResponse>>(paymentService.addPayment(addPaymentRequest), HttpStatus.CREATED);
    }

}
