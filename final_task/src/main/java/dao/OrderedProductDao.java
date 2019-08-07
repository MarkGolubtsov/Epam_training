package dao;

import domain.ChoseProduct;
import exception.DBException;

import java.util.List;

public interface OrderedProductDao extends Dao {
    List<ChoseProduct> readOrderProducts(int order_id) throws DBException;
    void addToOrder(int order_id,ChoseProduct choseProduct) throws DBException;
}
