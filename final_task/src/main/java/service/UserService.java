package service;

import domain.RoleUser;
import domain.User;

import java.util.List;

public interface UserService extends Service<User> {
    boolean registration(User user);
    User signIn(String name,String password);
    User findById(int id);
    void deleteById(int  id);
    List<User> findByRole(RoleUser roleUser);
    List<User> readByTelephone(String telephone);
    List<User> readByName(String name);
}
