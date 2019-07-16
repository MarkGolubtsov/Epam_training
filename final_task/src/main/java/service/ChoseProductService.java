package service;

import domain.ChoseProduct;
import exception.DBException;

import java.util.List;

public interface ChoseProductService extends Service<ChoseProduct> {
    void save(ChoseProduct choseProduct) throws DBException;

    List<ChoseProduct> findByOrderId(int order_id) throws DBException;

    void delete(ChoseProduct choseProduct) throws DBException;
    void update(ChoseProduct choseProduct) throws DBException;

}
