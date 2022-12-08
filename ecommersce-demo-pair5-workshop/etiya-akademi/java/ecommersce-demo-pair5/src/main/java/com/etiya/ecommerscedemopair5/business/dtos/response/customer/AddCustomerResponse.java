package com.etiya.ecommerscedemopair5.business.dtos.response.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCustomerResponse {
    private int id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private java.sql.Timestamp birthday;
}
