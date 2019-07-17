package service.implement;

import dao.ChoseProductDao;
import dao.DaoFactory;
import dao.OrderDao;
import dao.ProductDao;
import domain.ChoseProduct;
import domain.Order;
import exception.DBException;
import service.ChoseProductService;
import service.fill.FillOrder;

import java.util.List;

public class ChoseProductServiceImpl extends ServiceImpl implements ChoseProductService, FillOrder {
    public  ChoseProductServiceImpl(DaoFactory daoFactory) {
        super(daoFactory);
    }

    @Override
    public void save(ChoseProduct choseProduct) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        choseProductDao.create(choseProduct);
    }

    @Override
    public List<ChoseProduct> findByOrderId(int order_id) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        OrderDao orderDao = daoFactory.createDao(OrderDao.class);
        Order order = orderDao.readById(order_id);
        List<ChoseProduct> result = choseProductDao.read();
        for (ChoseProduct p:
             result) {
            fillProduct(p);
            p.setOrder(order);
        }
        return result;
    }

    @Override
    public void delete(ChoseProduct choseProduct) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        choseProductDao.delete(choseProduct);
    }


    @Override
    public List<ChoseProduct> findAll() throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        List<ChoseProduct> result = choseProductDao.read();
        for (ChoseProduct choseProduct:
                result) {
            fillProduct(choseProduct);
            fillOrder(choseProduct,daoFactory);
        }
        return result;
    }

    @Override
    public void update(ChoseProduct entity) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        choseProductDao.update(entity);
    }
    private  void  fillProduct(ChoseProduct choseProduct) throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        int product_id =choseProduct.getProduct().getId();
        choseProduct.setProduct(productDao.readById(product_id));
    }

}
