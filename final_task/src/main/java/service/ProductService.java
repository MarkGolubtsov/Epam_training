package service;

import domain.Product;
import exception.DBException;

import java.util.List;

public interface ProductService extends ServiceEntity<Product> {
    void delete(Product product) throws DBException;
    List<Product>  readByType(String type) throws DBException;
    List<Product>  readByName(String name) throws DBException;
    List<String>  readAllTypes() throws DBException;
    Product readById(int id) throws DBException;
    List<Product> read() throws DBException;
    Integer save(Product product) throws DBException;
}
