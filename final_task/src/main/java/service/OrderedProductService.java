package service;

import domain.ChoseProduct;
import exception.DBException;

import java.util.List;

public interface OrderedProductService extends Service {
    List<ChoseProduct> readOrderProduct(int order_id) throws DBException;
    void addInOrder(int order_id,ChoseProduct choseProduct)throws DBException;
}
