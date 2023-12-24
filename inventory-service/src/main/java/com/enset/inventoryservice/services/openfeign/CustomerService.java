package com.enset.inventoryservice.services.openfeign;

import com.enset.inventoryservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerService {
    @GetMapping("/api/v1/customers/search/{email}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer getCustomerByEmail(@PathVariable String email);
    default Customer getDefaultCustomer(Long id,Exception e){
        return Customer.builder()
                .id(id).email("noname@gmail.com").name("NotFount").email("NotFound@notfound.com").build();
    }
}
