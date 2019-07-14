package service;

import domain.Address;

import java.util.List;

interface AddressService extends Service<Address> {
    void  save(Address address);
    void deleteByUserId(int user_id);
    void delete(Address address);
    List<Address> readByStreet(String street);
    List<Address> readByHouse(int house);
}
