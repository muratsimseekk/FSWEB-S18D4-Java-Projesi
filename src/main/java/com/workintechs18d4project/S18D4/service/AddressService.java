package com.workintechs18d4project.S18D4.service;

import com.workintechs18d4project.S18D4.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddresses();
    Address getAddressByID(Long id);
    Address addAddress(Address address);
    Address updateAddress(Address address , Long id);
    Address deleteAddress(Long id);
}
