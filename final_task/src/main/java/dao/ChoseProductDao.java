package dao;

import domain.ChoseProduct;
import exception.DBException;

import java.util.List;

public interface ChoseProductDao extends Dao<ChoseProduct> {

    List<ChoseProduct> readByUserId(int user_id) throws DBException;
    List<ChoseProduct> readByProductId(int product_id) throws DBException;
    void deleteByProductId(int product_id ) throws DBException;

    List<ChoseProduct> readByUserIdAndProductId(int user_id, int product_id) throws DBException;
}
