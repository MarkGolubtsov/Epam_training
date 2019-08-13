package service.implement;


import dao.*;
import domain.RoleUser;
import domain.User;
import exception.DBException;
import service.UserService;
import service.implement.security.SecurityPassword;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends ServiceImpl implements UserService {

    private final  SecurityPassword securityPassword=new SecurityPassword();
    @Override
    public int registration(User user) throws DBException {
        String password=securityPassword.hidePassword(user.getPassword());
        user.setPassword(password);
        UserDao userDao = daoFactory.createDao(UserDao.class);
        User result=userDao.read(user.getName(),user.getPassword());
        if (result==null)
        {
            int final_res =-1;
            userDao = daoFactory.createDao(UserDao.class);
            final_res=userDao.create(user);
            return final_res;
        } else {
        return  -1;
        }

    }

    @Override
    public User signIn(String name, String password) throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        return userDao.read(name,securityPassword.hidePassword(password));
    }

    @Override
    public User findById(int id) throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        return userDao.readById(id);
    }

    @Override
    public List<User> readAll() throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        return userDao.read();
    }

    @Override
    public void deleteById(int id) throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        User user = new User();
        user.setId(id);
        userDao.delete(user);
    }

    @Override
    public List<User> findByRole(RoleUser roleUser) throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        return userDao.readByRole(roleUser);
    }

    @Override
    public List<User> readByTelephone(String telephone) throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        return userDao.readByTelephone(telephone);
    }

    @Override
    public List<User> readByName(String name) throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        return userDao.readByName(name);
    }

    @Override
    public List<User> findAll() throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        List<User> result =userDao.read();
        return result;
    }

    @Override
    public void update(User entity) throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        userDao.update(entity);
    }
}
