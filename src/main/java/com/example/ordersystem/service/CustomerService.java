package com.example.ordersystem.service;

import com.example.ordersystem.domain.create.CreateCustomer;
import com.example.ordersystem.domain.Customer;
import com.example.ordersystem.domain.dto.CustomerDto;
import com.example.ordersystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerDto newCustomer(CreateCustomer createCustomer) {
        Customer customer = Customer.newCustomer(createCustomer);
        Customer saved = customerRepository.save(customer);
        return CustomerDto.builder()
                .address(saved.getAddress())
                .name(saved.getName())
                .phoneNumber(saved.getPhoneNumber())
                .build();
    }
}
