package dao;

import domain.Order;
import domain.TypeDelivery;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    Order read(int id);

    List<Order> readByUserId(int user_id);

    List<Order> readByDeliveryType(TypeDelivery delivery_type);
}
