package service.fill;

import dao.DaoFactory;
import dao.UserDao;
import domain.ContainUser;
import domain.User;
import exception.DBException;

public interface FillUser {
    default void  fillUser(ContainUser obj, DaoFactory daoFactory) throws DBException {
        UserDao userDao =daoFactory.createDao(UserDao.class);
        User user =obj.getUser();
        obj.setUser(userDao.readById(user.getId()));
    }
}
