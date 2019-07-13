package dao;

import domain.Delivery;

import java.util.List;

public interface DeliveryDao extends Dao<Delivery> {
    List<Delivery> readByOrderId(int order_id);

    List<Delivery>  readByCourierId(int courier_id);

    Delivery reead(int order_id,int courier_id);

    List<Delivery> readByUserId(int user_id);


}
