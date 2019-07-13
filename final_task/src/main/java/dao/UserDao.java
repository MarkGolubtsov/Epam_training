package dao;

import domain.RoleUser;
import domain.User;
import exception.FitalException;

import java.util.List;

public interface UserDao extends Dao<User> {

    List<User> readByName (String name) throws FitalException;

    User read(String name ,String password) throws FitalException;

    User readById(int id) throws FitalException;

    List<User> readByRole(RoleUser roleUser) throws FitalException;

    List<User> readByTelephone(String telephone) throws FitalException;
}
