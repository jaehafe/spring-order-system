package com.example.ordersystem.repository;

import com.example.ordersystem.domain.StoreProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer> {

    Optional<StoreProduct> findByStoreIdAndProductId(int store, int productId);
}
