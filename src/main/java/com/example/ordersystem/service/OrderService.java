package com.example.ordersystem.service;

import com.example.ordersystem.domain.Order;
import com.example.ordersystem.domain.create.CreateOrder;
import com.example.ordersystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void newOrder(CreateOrder createOrder) {
        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
    }
}
