package com.enset.inventoryservice.repositories;

import com.enset.inventoryservice.entities.Customer_Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Customer_Order,Long> {
}
