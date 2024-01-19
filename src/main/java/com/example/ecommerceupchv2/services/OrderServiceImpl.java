package com.example.ecommerceupchv2.services;

import com.example.ecommerceupchv2.controllers.dtos.requests.CreateOrderRequest;
import com.example.ecommerceupchv2.controllers.dtos.requests.UpdateOrderRequest;
import com.example.ecommerceupchv2.controllers.dtos.responses.BaseResponse;
import com.example.ecommerceupchv2.controllers.dtos.responses.GetOrderResponse;
import com.example.ecommerceupchv2.entities.Order;
import com.example.ecommerceupchv2.repositories.IOrderRepository;
import com.example.ecommerceupchv2.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository repository;

    @Override
    public BaseResponse create(CreateOrderRequest request){
        if(repository.existsOrderByStatus((request.getStatus()))) {
            return BaseResponse.builder()
                    .data(null)
                    .message("Order already exists")
                    .success(Boolean.FALSE)
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return BaseResponse.builder()
                .data(toGetOrderResponse(repository.save(toOrder(request))))
                .message("Order created successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse get(Long id){
        if (!repository.existsById(id)){
            return orderDoesntExist();
        }

        return BaseResponse.builder()
                .data(toGetOrderResponse(repository.getOrderById(id)))
                .message("")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse update(Long Id, UpdateOrderRequest request){
        if (!repository.existsById(Id)){
            return orderDoesntExist();
        }
        return BaseResponse.builder()
                .data(toGetOrderResponse(repository.save(toOrderUpdate(request, Id))))
                .message("Order updated successfully")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse delete(Long Id){
        if(!repository.existsById(Id)){
            return orderDoesntExist();
        }
        repository.deleteById(Id);
        return BaseResponse.builder()
                .data(null)
                .message("Order deleted correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private BaseResponse orderDoesntExist() {
        return BaseResponse.builder()
                .data(null)
                .message("Order doesn't exist")
                .success(Boolean.FALSE)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }

    private GetOrderResponse toGetOrderResponse(Order order){
        GetOrderResponse response = new GetOrderResponse();
        response.setId(order.getId());
        response.setStatus(order.getStatus());
        return response;
    }

    private Order toOrder(CreateOrderRequest request){
        Order order = new Order();
        order.setStatus(request.getStatus());
        return order;
    }

    private Order toOrderUpdate(UpdateOrderRequest request, Long Id){
        Order order = new Order();
        order.setStatus(request.getStatus());
        return order;
    }
    @Override
    public Order findByStatus(String Status){
        return repository.findByStatus(Status);
    }
}
