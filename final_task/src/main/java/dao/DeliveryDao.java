package dao;

import domain.Delivery;
import exception.DBException;

import java.util.List;

public interface DeliveryDao extends DaoEntity<Delivery> {
    List<Delivery> readByOrderId(int order_id) throws DBException;

    List<Delivery>  readByCourierId(int courier_id) throws DBException;

    Delivery read(int order_id,int courier_id) throws DBException;

    List<Delivery> readByUserId(int user_id) throws DBException;


}
