package com.enset.inventoryservice.services.openfeign;

import com.enset.inventoryservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerService {
    @GetMapping("/api/v1/customers/search/{email}")
    Customer getCustomerByEmail(@PathVariable String email);
}
