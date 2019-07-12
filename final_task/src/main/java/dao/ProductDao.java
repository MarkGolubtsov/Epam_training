package dao;

import domain.Product;
import exception.FitalException;

import java.util.List;

public interface  ProductDao extends Dao {
    Product readById(int id);
    List<Product> readByType(String type);
    List<Product> readByName(String name) throws FitalException;

}
