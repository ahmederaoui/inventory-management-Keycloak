package com.enset.customerservice.services.impl;

import com.enset.customerservice.dtos.CustomerDto;
import com.enset.customerservice.entities.Customer;
import com.enset.customerservice.exceptions.EmailExistException;
import com.enset.customerservice.repositories.CustomerRepository;
import com.enset.customerservice.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public Customer createCustomer(CustomerDto customerDto) throws EmailExistException {
        Customer customer=getCustomerByEmail(customerDto.getEmail());
        if(customer!=null) throw new EmailExistException("This email already exist");
        return customerRepository.save(Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .build());
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public Page<Customer> getPageableCustomers(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return customerRepository.findAll(pageable);
    }

    @Override
    public void deleteCustomer(String email) {
        Customer customer=getCustomerByEmail(email);
        customerRepository.deleteById(customer.getId());
    }
}
