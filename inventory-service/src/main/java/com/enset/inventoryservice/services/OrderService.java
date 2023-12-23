package com.enset.inventoryservice.services;

import com.enset.inventoryservice.dtos.OrderDto;
import com.enset.inventoryservice.entities.Customer_Order;
import com.enset.inventoryservice.exceptions.OrderNotFound;
import com.enset.inventoryservice.exceptions.ProductNotFound;

import java.util.List;

public interface OrderService {
    Customer_Order getOrder(Long id) throws OrderNotFound;
    List<Customer_Order> getOrders();
    Customer_Order createOrder(OrderDto orderDto) throws ProductNotFound;
    void deleteOrder(Long id);
}
