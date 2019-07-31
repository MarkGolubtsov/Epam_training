package service;

import domain.Delivery;
import exception.DBException;

import java.util.List;

public interface DeliveryService extends ServiceEntity<Delivery> {
    void save(Delivery delivery) throws DBException;
    void update(Delivery delivery) throws DBException;
    void delete(Delivery delivery) throws DBException;
    List<Delivery> readByCourierId(int order_id) throws DBException;
    List<Delivery> readByUserId(int user_id) throws DBException;
}
