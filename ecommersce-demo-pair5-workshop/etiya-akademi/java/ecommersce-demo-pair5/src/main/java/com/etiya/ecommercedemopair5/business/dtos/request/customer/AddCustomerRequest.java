package com.etiya.ecommercedemopair5.business.dtos.request.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
   private String firstname;
   private String lastname;
   private String phoneNumber;
   private java.sql.Timestamp birthday;
}
