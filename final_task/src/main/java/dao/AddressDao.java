package dao;

import domain.Address;
import exception.DBException;

import java.util.List;

public interface AddressDao extends DaoEntity<Address> {

    List<Address> readByStreet(String street) throws DBException;
    List<Address> readByHouse (int house)  throws DBException;
    Address readByUserId(int user_id) throws DBException;
}
