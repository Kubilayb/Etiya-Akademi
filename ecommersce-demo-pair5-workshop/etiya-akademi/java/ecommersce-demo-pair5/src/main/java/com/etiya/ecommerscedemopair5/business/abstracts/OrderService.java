package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Order;

import java.sql.Date;
import java.util.List;


public interface OrderService {

    DataResult<List<Order>> getAll();
    DataResult<Order> getById(int id);
    DataResult<List<Order>> getByOrderDate(Date orderDate);

    DataResult<List<Order>> getALlOrderByCargoCompany(String cargoCompany);

  /*  DataResult<List<OrderDTO>> getAddressTitlesOfOrders();*/

    DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest);
}
