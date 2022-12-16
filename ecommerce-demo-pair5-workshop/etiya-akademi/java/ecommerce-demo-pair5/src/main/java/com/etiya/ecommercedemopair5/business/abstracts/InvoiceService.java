package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.request.invoice.AddInvoiceRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.invoice.AddInvoiceResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;

public interface InvoiceService {

    DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest);
}
