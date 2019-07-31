package service;

import domain.ChoseProduct;
import exception.DBException;

import java.util.List;

public interface CartService  extends Service {
    List<ChoseProduct> getUserCart(int user_id) throws DBException;
    void addInUserCart(int user_id,ChoseProduct choseProduct)throws DBException;
    void deleteFromUserCart(int user_id,ChoseProduct choseProduct)throws DBException;
}
