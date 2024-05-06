package com.example.ordersystem.service;

import com.example.ordersystem.domain.Order;
import com.example.ordersystem.domain.StoreProduct;
import com.example.ordersystem.domain.create.CreateOrder;
import com.example.ordersystem.repository.OrderRepository;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final StoreService storeService;

    public OrderService(OrderRepository orderRepository,
                        StoreService storeService) {
        this.orderRepository = orderRepository;
        this.storeService = storeService;
    }

    public void newOrder(CreateOrder createOrder) {
        List<StoreProduct> storeProducts = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry: createOrder.getQuantityByProduct().entrySet()) {
            Integer productId = entry.getKey();
            Integer buyQuantity = entry.getValue();

            StoreProduct storeProduct = storeService.getStoreProduct(
                    createOrder.getStoreId(),
                    productId);

            int stockQuantity = storeProduct.getStockQuantity();

            if (buyQuantity > stockQuantity) {
                throw new RuntimeException("재고가 없습니다.");
            }

            storeProduct.adjustStockQuantity(buyQuantity);
            storeProducts.add(storeProduct);
        }
        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
        storeService.saveAll(storeProducts);
    }
//        try {
//            for (Map.Entry<Integer, Integer> entry : createOrder.getQuantityByProduct().entrySet()) {
//                Integer productId = entry.getKey();
//                Integer buyQuantity = entry.getValue();
//
//                StoreProduct storeProduct = storeService.getStoreProduct(
//                        createOrder.getStoreId(),
//                        productId);
//
//                int stockQuantity = storeProduct.getStockQuantity();
//
//                if (buyQuantity > stockQuantity) {
//                    throw new RuntimeException("재고가 없습니다.");
//                }
//
//                storeProduct.adjustStockQuantity(buyQuantity);
//                storeProducts.add(storeProduct);
//            }
//            Order entity = Order.newOrder(createOrder);
//            orderRepository.save(entity);
//            storeService.saveAll(storeProducts);
//        } catch (IncorrectResultSizeDataAccessException ex) {
//            throw new RuntimeException("주문 처리 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요.", ex);
//        }
//    }
}
