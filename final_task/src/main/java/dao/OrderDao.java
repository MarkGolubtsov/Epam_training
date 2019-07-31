package dao;

import domain.Order;
import domain.TypeDelivery;
import domain.TypePay;
import exception.DBException;

import java.util.List;

public interface OrderDao extends DaoEntity<Order> {
    Order readById(int id) throws DBException;
    void deleteByUserId(int user_id) throws DBException;
    List<Order> readByUserId(int user_id) throws DBException;
    List<Order> readByDeliveryType(TypeDelivery delivery_type) throws DBException;
    List<Order> readByPayType(TypePay typePay) throws DBException;
}
