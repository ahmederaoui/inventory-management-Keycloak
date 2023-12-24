package com.enset.inventoryservice.models;

import jakarta.persistence.Entity;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
}
