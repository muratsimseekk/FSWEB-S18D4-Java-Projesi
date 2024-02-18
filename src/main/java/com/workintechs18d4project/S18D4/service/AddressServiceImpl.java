package com.workintechs18d4project.S18D4.service;

import com.workintechs18d4project.S18D4.entity.Address;
import com.workintechs18d4project.S18D4.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressByID(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
//        optionalAddress.orElseThrow(()->new RuntimeException("Account not found")); bu tarz da yazialbilir.
        if (optionalAddress.isPresent()){
            return optionalAddress.get();
        }
        //TODO Exception Handling
        return null;
    }

    @Override
    public Address addAddress(Address address) {
        //TODO eger eklenmek istenen address in idsi listede varsa Exception firlat.
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address, Long id) {
        Optional<Address> optionalAddress= addressRepository.findById(id);
        if (optionalAddress.isPresent()){
            Address existingAddress= optionalAddress.get();
            existingAddress.setStreet(address.getStreet());
            existingAddress.setNo(address.getNo());
            existingAddress.setCity(address.getCity());
            existingAddress.setCountry(address.getCountry());
            existingAddress.setDescription(address.getDescription());

            return addressRepository.save(existingAddress);
        }
        //TODO ID bulunamazsa Exception firlat.
        return null;

    }

    @Override
    public Address deleteAddress(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()){
            addressRepository.deleteById(id);
        }
        //TODO Girilen address listede yoksa Exception firlat
        return null;
    }
}
