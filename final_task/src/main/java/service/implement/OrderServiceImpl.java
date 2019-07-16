package service.implement;

import dao.DaoFactory;
import dao.OrderDao;
import domain.Delivery;
import domain.Order;
import domain.TypeDelivery;
import domain.TypePay;
import exception.DBException;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl extends ServiceImpl implements OrderService {
    public  OrderServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public void save(Order order) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        orderDao.create(order);
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
        return  orderDao.readById(id);
    }

    @Override
    public List<Order> readByUserId(int user_id) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        return orderDao.readByUserId(user_id);
    }

    @Override
    public List<Order> readByTypePay(TypePay typePay) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        return orderDao.readByPayType(typePay);
    }

    @Override
    public List<Order> readByDelivery(TypeDelivery delivery) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        return orderDao.readByDeliveryType(delivery);
    }

    @Override
    public List<Order> findAll() throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        return orderDao.read();
    }

    @Override
    public void update(Order entity) throws DBException {
        OrderDao  orderDao = daoFactory.createDao(OrderDao.class);
        orderDao.update(entity);
    }
}
