package com.example.ordersystem.domain.create;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class CreateOrder {
    private int customerId;
    private int storeId;
    private Map<Integer, Integer> quantityByProduct; // ["아메리카노, 3"]
}
