package com.workintechs18d4project.S18D4.controller;

import com.workintechs18d4project.S18D4.entity.Customer;
import com.workintechs18d4project.S18D4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomerList(){
        return customerService.getCustomersList();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerByID(@PathVariable Long id){
        return customerService.getCustomerByID(id);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer , @PathVariable Long id){
        return customerService.updateCustomer(customer,id);
    }

    @DeleteMapping("/customers/{id}")
    public Customer removeCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

}
