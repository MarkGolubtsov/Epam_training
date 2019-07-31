package service;

import domain.ChoseProduct;
import exception.DBException;

public interface ChoseProductService extends ServiceEntity<ChoseProduct> {
    Integer save(ChoseProduct choseProduct) throws DBException;
    void delete(ChoseProduct choseProduct) throws DBException;
    void update(ChoseProduct choseProduct) throws DBException;
   ChoseProduct findById(int chose_product_id) throws DBException;
}
