package dao;

import domain.ChoseProduct;
import exception.DBException;

import java.util.List;

public interface ChoseProductDao extends Dao<ChoseProduct> {

    List<ChoseProduct> readByOrderId(int order_id) throws DBException;
    List<ChoseProduct> readByProductId(int product_id) throws DBException;
    void deleteByProductId(int product_id ) throws DBException;
}
