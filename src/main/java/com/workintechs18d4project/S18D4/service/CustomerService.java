package com.workintechs18d4project.S18D4.service;

import com.workintechs18d4project.S18D4.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> getCustomersList();
    Customer getCustomerByID(Long id);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer , Long id);
    Customer deleteCustomer(Long id);
}
