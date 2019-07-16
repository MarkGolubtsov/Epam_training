package service;

import domain.Order;
import domain.TypeDelivery;
import domain.TypePay;
import exception.DBException;

import java.util.List;

public interface OrderService extends Service<Order> {

    void save(Order order) throws DBException;
    void deleteByUserId(int user_id) throws DBException;
    void deleteById(int id) throws DBException;
    Order readById(int id ) throws  DBException;
    List<Order> readByUserId(int user_id) throws DBException;
    List<Order> readByTypePay(TypePay typePay) throws DBException;
    List<Order> readByDelivery(TypeDelivery typePay) throws DBException;
}
