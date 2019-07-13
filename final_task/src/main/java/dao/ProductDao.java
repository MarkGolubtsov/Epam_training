package dao;

import domain.Product;
import exception.FitalException;

import java.util.List;

public interface  ProductDao extends Dao<Product> {
    List<String> getTypes() throws FitalException;
    Product readById(int id) throws FitalException;
    List<Product> readByType(String type) throws FitalException;
    List<Product> readByName(String name) throws FitalException;

}
