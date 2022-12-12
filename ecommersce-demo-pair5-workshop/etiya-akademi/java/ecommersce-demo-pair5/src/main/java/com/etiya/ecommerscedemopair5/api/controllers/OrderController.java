package com.etiya.ecommerscedemopair5.api.controllers;

import com.etiya.ecommerscedemopair5.business.abstracts.OrderService;
import com.etiya.ecommerscedemopair5.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/app/orders")
public class OrderController{
    private OrderService orderService;

    @GetMapping("/getAll")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/getById")
    public Order getById(int id) {
        return orderService.getById(id);
    }

    @GetMapping("/getByOrderDate")
    public List<Order> getByOrderDate(Date orderDate) {
        return orderService.getByOrderDate(orderDate);
    }

    @PostMapping("/add")
    public ResponseEntity<AddOrderResponse> addOrder(@RequestBody AddOrderRequest addOrderRequest){
        return new ResponseEntity<AddOrderResponse>(orderService.addOrder(addOrderRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getALlOrderByCargoCompany")
    public List<Order> getALlOrderByCargoCompany(@RequestParam(value = "cargoCompany")String cargoCompany){
        return orderService.getALlOrderByCargoCompany(cargoCompany);
    }

    /*@GetMapping("/getAddressTitlesOfOrders")
    public DataResult<List<OrderDTO>> getAddressTitlesOfOrders(){
        return new SuccessDataResult<List<OrderDTO>>(orderService.getAddressTitlesOfOrders().getData());
    }*/

}
