package com.etiya.ecommerscedemopair5.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
   private int id;
   private String name;
   private String addressTitleName;

}
