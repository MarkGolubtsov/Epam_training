package dao;

import domain.Delivery;
import exception.FitalException;

import java.util.List;

public interface DeliveryDao extends Dao<Delivery> {
    List<Delivery> readByOrderId(int order_id) throws FitalException;

    List<Delivery>  readByCourierId(int courier_id) throws FitalException;

    Delivery read(int order_id,int courier_id) throws FitalException;

    List<Delivery> readByUserId(int user_id) throws FitalException;


}
