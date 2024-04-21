package com.example.ordersystem.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "orders")
public class Order {
    @Id
    private int orderId;

    @Column
    private int customerId;

    @Column
    private Timestamp orderAt;

    @MappedCollection(idColumn = "order_item_id", keyColumn = "order_id")
    private List<OrderItem> orderItems = new ArrayList<>();
}
