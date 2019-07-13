package dao;

import domain.Address;
import exception.FitalException;

import java.util.List;

public interface AddressDao extends Dao<Address>{

    List<Address> readByStreet(String street) throws FitalException;
    List<Address> readByHouse (int house)  throws FitalException ;
}
