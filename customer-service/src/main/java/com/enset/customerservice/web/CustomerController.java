package com.enset.customerservice.web;

import com.enset.customerservice.dtos.CustomerDto;
import com.enset.customerservice.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/search")
    public ResponseEntity<?> getCustomers(@RequestParam int page,@RequestParam int size){
        try {
            return ResponseEntity.ok(customerService.getPageableCustomers(page,size));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/search/{email}")
    public ResponseEntity<?> getCustomerByEmail(@PathVariable String email){
        try {
            return ResponseEntity.ok(customerService.getCustomerByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deleteCustomerByEmail(@PathVariable String email){
        try {
            customerService.deleteCustomer(email);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDto customerDto){
        try {
            return ResponseEntity.ok(customerService.createCustomer(customerDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
