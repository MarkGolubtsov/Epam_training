package service;

import domain.Delivery;

import java.util.List;

public interface DeliveryService extends Service<Delivery> {
    void save(Delivery delivery);
    void delete(Delivery delivery);
    void deleteByUserId(int user_id);
    void deleteByOrderId(int order_id);
    void deleteByCourierId(int courier_id);
    List<Delivery> readByCourierId(int order_id);
}
