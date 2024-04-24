package com.example.ordersystem.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;

@Table(name = "store_products")
public class StoreProduct {
    @Id
    private String storeProductId;

    @Column
    private String storeId;

    @Column
    private String productId;

    @Column
    private String stockQuantity;
}
