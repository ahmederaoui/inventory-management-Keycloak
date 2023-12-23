package com.enset.inventoryservice.dtos;

import com.enset.inventoryservice.entities.Product;
import com.enset.inventoryservice.models.Customer;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.Date;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Date orderDate;
    private int quantity;
    private String productId;
    private String customerEmail;
}
