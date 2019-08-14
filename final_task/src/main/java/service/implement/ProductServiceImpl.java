package service.implement;

import dao.ProductDao;
import domain.Product;
import exception.DBException;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl extends ServiceImpl implements ProductService {

    @Override
    public void delete(Product product) throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        productDao.delete(product);
    }

    @Override
    public List<domain.Product> readByType(String type) throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        return productDao.readByType(type);
    }

    @Override
    public List<domain.Product> readByName(String name) throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        return productDao.readByName(name);
    }

    @Override
    public List<String> readAllTypes() throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        return productDao.readTypes();
    }

    @Override
    public Product readById(int id) throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        return productDao.readById(id);
    }

    @Override
    public List<Product> read() throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        return productDao.read();
    }

    @Override
    public Integer save(Product product) throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        return productDao.create(product);
    }

    @Override
    public List<domain.Product> findAll() throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        return productDao.read();
    }

    @Override
    public void update(Product entity) throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        productDao.update(entity);
    }
}
