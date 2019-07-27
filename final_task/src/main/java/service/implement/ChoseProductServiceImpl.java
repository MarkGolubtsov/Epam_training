package service.implement;

import dao.*;
import domain.ChoseProduct;
import domain.Order;
import domain.User;
import exception.DBException;
import service.ChoseProductService;
import service.fill.FillOrder;
import service.fill.FillUser;

import java.util.List;

public class ChoseProductServiceImpl extends ServiceImpl implements ChoseProductService, FillUser {

    @Override
    public void save(ChoseProduct choseProduct) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        choseProductDao.create(choseProduct);
    }
//TODo
//    @Override
//    public List<ChoseProduct> findByOrderId(int order_id) throws DBException {
//        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
//        OrderDao orderDao = daoFactory.createDao(OrderDao.class);
//        Order order = orderDao.readById(order_id);
//        List<ChoseProduct> result = choseProductDao.read();
//        for (ChoseProduct p:
//             result) {
//            fillProduct(p);
//            p.setOrder(order);
//        }
//        return result;
//    }

    @Override
    public List<ChoseProduct> findByUserId(int user_id) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        List<ChoseProduct> result = choseProductDao.readByUserId(user_id);
        for (ChoseProduct p:
             result) {
            fillProduct(p);
           fillUser(p,daoFactory);
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
            fillUser(choseProduct,daoFactory);
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
