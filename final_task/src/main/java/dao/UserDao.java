package dao;

import domain.RoleUser;
import domain.User;
import exception.DBException;

import java.util.List;

public interface UserDao extends DaoEntity<User> {

    List<User> readByName (String name) throws DBException;

    User read(String name ,String password) throws DBException;

    User readById(int id) throws DBException;

    List<User> readByRole(RoleUser roleUser) throws DBException;

    List<User> readByTelephone(String telephone) throws DBException;
}
