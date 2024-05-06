package com.example.ordersystem.controller;

import com.example.ordersystem.domain.create.CreateOrder;
import com.example.ordersystem.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/orders")
    public Response<Void> newOrder() {
        HashMap<Integer, Integer> orderMap = new HashMap<>();
        orderMap.put(1, 5);
        orderMap.put(2, 10);
        orderService.newOrder(CreateOrder.builder()
                .customerId(1)
                .quantityByProduct(orderMap)
                .build());

        return Response.success(null);
    }
}
