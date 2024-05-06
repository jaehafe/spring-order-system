package com.example.ordersystem.repository;

import com.example.ordersystem.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {}
