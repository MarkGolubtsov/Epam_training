package dao;

import domain.Product;
import exception.DBException;

import java.util.List;

public interface  ProductDao extends Dao<Product> {
    List<String> readTypes() throws DBException;
    Product readById(int id) throws DBException;
    List<Product> readByType(String type) throws DBException;
    List<Product> readByName(String name) throws DBException;

}
