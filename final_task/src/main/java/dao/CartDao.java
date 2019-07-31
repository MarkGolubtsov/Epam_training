package dao;

import domain.ChoseProduct;
import exception.DBException;

import java.util.List;

public interface CartDao extends Dao {
    List<ChoseProduct> getUserCart(int user_id) throws DBException;
    void addToCart(int user_id,ChoseProduct choseProduct) throws DBException;
    void deleteFromCart(int user_id,ChoseProduct choseProduct)throws DBException;
}
