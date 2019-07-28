package service;

import domain.ChoseProduct;
import exception.DBException;

import java.util.List;

public interface ChoseProductService extends Service<ChoseProduct> {
    void save(ChoseProduct choseProduct) throws DBException;

    List<ChoseProduct> findByUserId(int user_id) throws DBException;
    ChoseProduct findByUserIdAndProductId(int user_id,int product_id) throws DBException;

    void delete(ChoseProduct choseProduct) throws DBException;
    void update(ChoseProduct choseProduct) throws DBException;

}
