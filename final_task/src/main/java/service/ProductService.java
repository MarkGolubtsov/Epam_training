package service;

import domain.Product;

import java.util.List;

interface ProductService extends Service<Product> {
    void delete(Product product);
    List<Product>  readByType(String type);
    List<Product>  readByName(String type);
    List<String>  readAllTypes();
}
