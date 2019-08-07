package service.implement;

import dao.DaoFactory;
import dao.OrderDao;
import dao.UserDao;
import domain.*;
import exception.DBException;
import service.OrderService;
import service.fill.FillOrder;
import service.fill.FillUser;

import java.util.List;

public class OrderServiceImpl extends ServiceImpl implements OrderService, FillUser {

    @Override
    public int save(Order order) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        return orderDao.create(order);
    }

    @Override
    public void deleteByUserId(int user_id) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        orderDao.deleteByUserId(user_id);
    }

    @Override
    public void deleteById(int id) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        Order order = new Order();
        order.setId(id);
        orderDao.delete(order);
    }

    @Override
    public Order readById(int id) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        Order order=  orderDao.readById(id);
        fillUser(order,daoFactory);
        return order;
    }

    @Override
    public List<Order> readByUserId(int user_id) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        UserDao userDao = daoFactory.createDao(UserDao.class);
        List<Order> result = orderDao.readByUserId(user_id);
        User user = userDao.readById(user_id);
        for (Order order:
             result) {
            order.setUser(user);
        }
        return result ;
    }

    @Override
    public List<Order> readByTypePay(TypePay typePay) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        List<Order> result = orderDao.readByPayType(typePay);
        fillList(result);
        return result;
    }

    @Override
    public List<Order> readByDelivery(TypeDelivery delivery) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        List<Order> result =orderDao.readByDeliveryType(delivery);
        fillList(result);
        return result;
    }

    @Override
    public List<Order> findAll() throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        List<Order> result =orderDao.read();
        fillList(result);
        return  result;
    }

    @Override
    public void update(Order entity) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        orderDao.update(entity);
    }

    private void fillList(List<Order> list) throws DBException {
        for (Order order:
             list) {
            fillUser(order,daoFactory);
        }
    }
}
