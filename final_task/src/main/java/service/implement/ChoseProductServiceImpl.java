package service.implement;

import dao.*;
import domain.ChoseProduct;
import exception.DBException;
import org.apache.log4j.Logger;
import service.ChoseProductService;

import java.util.List;

public class ChoseProductServiceImpl extends ServiceImpl implements ChoseProductService {
    private static Logger logger = Logger.getLogger(ChoseProduct.class);
    @Override
    public Integer save(ChoseProduct choseProduct) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        return  choseProductDao.create(choseProduct);
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
        }
        return result;
    }

    @Override
    public void update(ChoseProduct entity) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        choseProductDao.update(entity);
    }

    @Override
    public ChoseProduct findById(int chose_product_id) throws DBException {
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        ChoseProduct res =choseProductDao.readById(chose_product_id);
        fillProduct(res);
        return res;
    }

    private  void  fillProduct(ChoseProduct choseProduct) throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        logger.debug("Find Product"+choseProduct.getProduct().getId());
        int product_id =choseProduct.getProduct().getId();
        choseProduct.setProduct(productDao.readById(product_id));
    }

}
