package com.enset.inventoryservice.services.impl;

import com.enset.inventoryservice.dtos.OrderDto;
import com.enset.inventoryservice.entities.Customer_Order;
import com.enset.inventoryservice.entities.Product;
import com.enset.inventoryservice.exceptions.OrderNotFound;
import com.enset.inventoryservice.exceptions.ProductNotFound;
import com.enset.inventoryservice.models.Customer;
import com.enset.inventoryservice.repositories.OrderRepository;
import com.enset.inventoryservice.services.OrderService;
import com.enset.inventoryservice.services.ProductService;
import com.enset.inventoryservice.services.openfeign.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ProductService productService;
    private final CustomerService customerService;
    private final OrderRepository orderRepository;
    @Override
    public Customer_Order getOrder(Long id) throws OrderNotFound {
        Customer_Order customerOrder =orderRepository.findById(id).orElseThrow(()->new OrderNotFound("This order doesn't exist"));
        Customer customer=customerService.getCustomerByEmail(customerOrder.getCustomerEmail());
        customerOrder.setCustomer(customer);
        return customerOrder;
    }

    @Override
    public List<Customer_Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Customer_Order createOrder(OrderDto orderDto) throws ProductNotFound {
        Product product=productService.getProduct(orderDto.getProductId());
        return orderRepository.save(Customer_Order.builder()
                .orderDate(new Date())
                .product(product)
                .quantity(orderDto.getQuantity())
                .customerEmail(orderDto.getCustomerEmail())
                .build());
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
