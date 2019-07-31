package service;

import domain.Address;
import exception.DBException;

import java.util.List;

public interface AddressService extends ServiceEntity<Address> {
    void  save(Address address) throws DBException;
    void delete(Address address) throws DBException;
    List<Address> readByStreet(String street) throws DBException;
    List<Address> readByHouse(int house) throws DBException;
}
