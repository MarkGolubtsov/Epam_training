package service;

import domain.Order;
import domain.TypePay;

public interface OrderService extends Service<Order> {

    void save(Order order);
    void deleteByUserId(int user_id);
    void deleteById(int id);
    void readByUserId(int user_id);
    void readByTypePay(TypePay typePay);
}
