package com.workintechs18d4project.S18D4.controller;

import com.workintechs18d4project.S18D4.entity.Address;
import com.workintechs18d4project.S18D4.service.AddressService;
import com.workintechs18d4project.S18D4.service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<Address> getAddressList(){
        return addressService.getAddresses();
    }

    @GetMapping("/address/{id}")
    public Address getAddressByID(@PathVariable Long id){
        return addressService.getAddressByID(id);
    }

    @PostMapping("/address")
    public Address addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@RequestBody Address address ,@PathVariable Long id){
        return addressService.updateAddress(address , id);
    }

    @DeleteMapping("/address/{id}")
    public Address deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}

