package service.implement;

import dao.ChoseProductDao;
import dao.OrderedProductDao;
import dao.ProductDao;
import domain.ChoseProduct;
import exception.DBException;
import service.OrderedProductService;
import service.fill.FillOrder;

import java.util.List;

public class OrderedProductServiceImpl extends ServiceImpl implements OrderedProductService {


    private  void  fill(ChoseProduct f,ChoseProduct r) {
        f.setId(r.getId());
        f.setCount(r.getCount());
        f.setProduct(r.getProduct());
    }
    private  void  fillProduct(ChoseProduct choseProduct) throws DBException {
        ProductDao productDao = daoFactory.createDao(ProductDao.class);
        int product_id =choseProduct.getProduct().getId();
        choseProduct.setProduct(productDao.readById(product_id));
    }

    @Override
    public List<ChoseProduct> readOrderProduct(int order_id) throws DBException {
        OrderedProductDao orderedProductDao= daoFactory.createDao(OrderedProductDao.class);
        List<ChoseProduct> choseProducts=orderedProductDao.readOrderProducts(order_id);
        for (ChoseProduct c:
                choseProducts) {
            ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
            ChoseProduct choseProduct =choseProductDao.readById(c.getId());
            fill(c,choseProduct);
            fillProduct(c);
        }
        return choseProducts;
    }

    @Override
    public void addInOrder(int order_id, ChoseProduct choseProduct) throws DBException {
        OrderedProductDao orderedProductDao= daoFactory.createDao(OrderedProductDao.class);
        orderedProductDao.addToOrder(order_id,choseProduct);
    }
}
