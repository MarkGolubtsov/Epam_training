package service.implement;

import dao.CartDao;
import dao.ChoseProductDao;
import dao.ProductDao;
import domain.ChoseProduct;
import exception.DBException;
import service.CartService;
import service.ChoseProductService;

import java.util.List;

public class CartServiceImpl extends ServiceImpl implements CartService{

    @Override
    public List<ChoseProduct> getUserCart(int user_id) throws DBException {
        CartDao cartDao = daoFactory.createDao(CartDao.class);
        ChoseProductDao choseProductDao = daoFactory.createDao(ChoseProductDao.class);
        List<ChoseProduct> choseProducts= cartDao.getUserCart(user_id);
        for (ChoseProduct c:
             choseProducts) {
            ChoseProduct choseProduct =choseProductDao.readById(c.getId());
            fill(c,choseProduct);
            fillProduct(c);
        }
        return choseProducts;
    }

    @Override
    public void addInUserCart(int user_id, ChoseProduct choseProduct) throws DBException {
        CartDao cartDao = daoFactory.createDao(CartDao.class);
        ChoseProductDao choseProductDao= daoFactory.createDao(ChoseProductDao.class);
        cartDao.addToCart(user_id,choseProduct);
    }

    @Override
    public void deleteFromUserCart(int user_id, ChoseProduct choseProduct) throws DBException {
        CartDao cartDao = daoFactory.createDao(CartDao.class);
        cartDao.deleteFromCart(user_id,choseProduct);
    }

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
}
