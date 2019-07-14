package dao;

import domain.ChoseProduct;
import exception.FitalException;

import java.util.List;

public interface ChoseProductDao extends Dao<ChoseProduct> {

    List<ChoseProduct> readByOrderId(int order_id) throws FitalException;
    List<ChoseProduct> readByProductId(int product_id) throws FitalException;
}
