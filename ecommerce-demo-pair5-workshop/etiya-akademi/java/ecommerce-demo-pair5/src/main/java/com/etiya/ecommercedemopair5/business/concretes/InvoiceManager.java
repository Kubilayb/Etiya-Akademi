package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.InvoiceService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.invoice.AddInvoiceRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.invoice.AddInvoiceResponse;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Customer;
import com.etiya.ecommercedemopair5.entities.concretes.Invoice;
import com.etiya.ecommercedemopair5.repository.abstracts.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;


    @Override
    public DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest) {
        Invoice invoice = modelMapperService.forRequest().map(addInvoiceRequest, Invoice.class);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        AddInvoiceResponse response = modelMapperService.forResponse().map(savedInvoice,AddInvoiceResponse.class);

        return new SuccessDataResult<AddInvoiceResponse>(response,messageSource.getMessage
                (Messages.Invoice.addInvoice,null,
                LocaleContextHolder.getLocale()));

    }
}