package com.enset.inventoryservice.entities;

import com.enset.inventoryservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Customer_Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    private int quantity;
    @ManyToOne
    private Product product;
    private String customerEmail;
    @Transient private Customer customer;
}
