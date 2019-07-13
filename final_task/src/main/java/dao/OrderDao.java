package dao;

import domain.Order;
import domain.TypeDelivery;
import exception.FitalException;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    Order readById(int id) throws FitalException;

    List<Order> readByUserId(int user_id) throws FitalException;

    List<Order> readByDeliveryType(TypeDelivery delivery_type) throws FitalException;
}
