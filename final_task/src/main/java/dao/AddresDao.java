package dao;

import domain.Adress;

import java.util.List;

public interface AddresDao  extends Dao<Adress>{

    List<Adress> readByStreet(String street);
    List<Adress> readByUserId(int id);
    void deleteAllAdressUser(int user_id);
}
