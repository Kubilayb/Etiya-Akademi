package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.*;
import com.etiya.ecommerscedemopair5.business.constants.Messages;
import com.etiya.ecommerscedemopair5.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.*;
import com.etiya.ecommerscedemopair5.repository.abstracts.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.MarshalException;
import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private OrderRepository orderRepository;

    private ModelMapperService modelMapperService;

   /* private CustomerService customerService;
    private AddressService addressService;
    private PaymentService paymentService;
    private CargoService cargoService;
    private ProductService productService;*/

    @Override
    public DataResult<List<Order>> getAll() {
        List<Order> response = this.orderRepository.findAll();
        return new SuccessDataResult<List<Order>>(response, Messages.Order.getAllOrder);
    }
    @Override
    public DataResult<Order> getById(int id) {
        Order response = this.orderRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Order>(response,Messages.Order.getByOrderId);
    }
    @Override
    public DataResult<List<Order>> getByOrderDate(Date orderDate) {
        List<Order> response = this.orderRepository.findByOrderDate(orderDate);
        return new SuccessDataResult<List<Order>>(response,Messages.Order.getOrderDate);
    }

    @Override
    public DataResult<List<Order>> getALlOrderByCargoCompany(String cargoCompany) {
        String cargoComp = cargoCompany.toLowerCase();
        List<Order> response = this.orderRepository.getALlOrderByCargoCompany(cargoCompany);
        return new SuccessDataResult<List<Order>>(response,Messages.Order.getAllOrderByCargoCompany);
    }
   /* @Override
    public DataResult<List<OrderDTO>> getAddressTitlesOfOrders() {
        return new SuccessDataResult<>(orderRepository.getAddressTitlesOfOrders());
    }*/
    @Override
    public DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest) {

        Order order = modelMapperService.forRequest().map(addOrderRequest,Order.class);
        AddOrderResponse addOrderResponse =
                modelMapperService.forResponse().map(orderRepository.save(order),AddOrderResponse.class);
        return new SuccessDataResult<AddOrderResponse>(addOrderResponse,Messages.Order.addOrder);
    }
}
    /*
    Order order = new Order();
        order.setDate(addOrderRequest.getDate());


       // order.setInvoices(addOrderRequest.getOrderid()); !''+'+'+'+'+'+'+


        Customer customer = customerService.getById(addOrderRequest.getCustomerid());
        order.setCustomers(customer);

        Address address= addressService.getById(addOrderRequest.getAddressid());
        order.setAddress(address);

        Payment payment=paymentService.getById(addOrderRequest.getPaymentid());
        order.setPayment(payment);

        Cargo cargo = cargoService.getById(addOrderRequest.getCargoid());
        order.setCargo(cargo);

        Product product = productService.getById(addOrderRequest.getProductid());
        order.setProduct(product);



        Order savedOrder=orderRepository.save(order);

        AddOrderResponse response = new AddOrderResponse(savedOrder.getId(),
                savedOrder.getDate(),
                savedOrder.getCustomers().getId(),
                savedOrder.getAddress().getId(),
                savedOrder.getPayment().getId(),
                savedOrder.getCargo().getId(),
                savedOrder.getProduct().getId());
        return response;
     */

