package service;

import domain.RoleUser;
import domain.User;
import exception.DBException;

import java.util.List;

public interface UserService extends ServiceEntity<User> {
    boolean registration(User user) throws DBException;
    User signIn(String name,String password) throws DBException;
    User findById(int id) throws DBException;
    void deleteById(int  id) throws DBException;
    List<User> findByRole(RoleUser roleUser) throws DBException;
    List<User> readByTelephone(String telephone) throws DBException;
    List<User> readByName(String name) throws DBException;
}
