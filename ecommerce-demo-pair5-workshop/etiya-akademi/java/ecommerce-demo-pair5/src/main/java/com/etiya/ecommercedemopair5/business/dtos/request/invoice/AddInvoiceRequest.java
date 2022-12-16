package com.etiya.ecommercedemopair5.business.dtos.request.invoice;

import lombok.*;

import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class AddInvoiceRequest {
    @Size(min = 6)
    private int orderId;

    private Date orderDate;

}
