package service.implement;


import dao.*;
import domain.RoleUser;
import domain.User;
import exception.DBException;
import service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl extends ServiceImpl implements UserService {

   public UserServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }
    @Override
    public boolean registration(User user) throws DBException {
        Optional<User> result = Optional.of(signIn(user.getName(),user.getPassword()));
        if (result.isEmpty())
        {
            UserDao userDao = daoFactory.createDao(UserDao.class);
            userDao.create(user);
            return true;
        } else {
        return  false;
        }
    }

    @Override
    public User signIn(String name, String password) throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        return userDao.read(name,password);
    }

    @Override
    public User findById(int id) throws DBException {
        UserDao userDao = daoFactory.createDao(UserDao.class);
        return userDao.readById(id);
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
        return readByTelephone(telephone);
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
