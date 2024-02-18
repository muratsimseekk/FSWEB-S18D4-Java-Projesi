package com.workintechs18d4project.S18D4.service;

import com.workintechs18d4project.S18D4.entity.Customer;
import com.workintechs18d4project.S18D4.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getCustomersList() {
       return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByID(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
       return customerOptional.orElseThrow(()-> new RuntimeException("Buraya Exception olustur"));
    }

    @Override
    public Customer addCustomer(Customer customer) {
        //TODO Customer id nin ayni olma durumu icin Exception firlat.
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()){
            Customer existCustomer = customerOptional.get();
            existCustomer.setFirstName(customer.getFirstName());
            existCustomer.setLastName(customer.getLastName());
            existCustomer.setEmail(customer.getEmail());
            existCustomer.setSalary(customer.getSalary());
            existCustomer.setAddress(customer.getAddress());
                    //existCustomer.getAccounts().add(customer);
        }
        //TODO ID eslesmiyorsa Exception firlat.
        return null;
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()){
            customerRepository.deleteById(id);
        }
        //TODO Eger listede silinecek id de Customer yoksa Exception firlat .
        return null;
    }
}
