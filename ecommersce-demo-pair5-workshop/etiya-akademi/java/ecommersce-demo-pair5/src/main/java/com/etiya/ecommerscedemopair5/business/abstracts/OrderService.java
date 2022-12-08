package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Order;

import java.sql.Date;
import java.util.List;


public interface OrderService {

    List<Order> getAll();
    Order getById(int id);
    List<Order> getByOrderDate(Date orderDate);

    AddOrderResponse addOrder(AddOrderRequest addOrderRequest);
}
