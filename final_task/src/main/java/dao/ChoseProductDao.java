package dao;

import domain.ChoseProduct;
import exception.DBException;

import java.util.List;

public interface ChoseProductDao extends DaoEntity<ChoseProduct> {

    List<ChoseProduct> readByProductId(int product_id) throws DBException;
    void deleteByProductId(int product_id ) throws DBException;
    ChoseProduct readById(int id)throws DBException;
}
