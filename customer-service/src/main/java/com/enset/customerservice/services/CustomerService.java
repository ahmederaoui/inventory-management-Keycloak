package com.enset.customerservice.services;

import com.enset.customerservice.dtos.CustomerDto;
import com.enset.customerservice.entities.Customer;
import com.enset.customerservice.exceptions.EmailExistException;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Customer getCustomerByEmail(String email);
    Customer createCustomer(CustomerDto customerDto) throws EmailExistException;
    Customer updateCustomer(CustomerDto customerDto);
    Page<Customer> getPageableCustomers(int page , int size);
    void deleteCustomer(String email);
}
