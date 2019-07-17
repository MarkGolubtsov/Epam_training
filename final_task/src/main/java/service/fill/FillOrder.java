package service.fill;

import dao.DaoFactory;
import dao.OrderDao;
import dao.UserDao;
import domain.ChoseProduct;
import domain.ContainOrder;
import domain.ContainUser;
import domain.User;
import exception.DBException;

public interface FillOrder {

     default void  fillOrder(ContainOrder obj,DaoFactory daoFactory) throws DBException {
        OrderDao orderDao = daoFactory.createDao(OrderDao.class);
        int oreder_id =obj.getOrder().getId();
        obj.setOrder(orderDao.readById(oreder_id));
    }
}
