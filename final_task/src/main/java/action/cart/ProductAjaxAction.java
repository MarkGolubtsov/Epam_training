package action.cart;

import action.role.ajax.UserActionAjax;
import domain.ChoseProduct;
import domain.Product;
import domain.User;
import exception.DBException;
import service.CartService;
import service.ChoseProductService;
import service.ProductService;
import service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public abstract class ProductAjaxAction extends UserActionAjax {
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse response) throws IOException, DBException {
        ServiceFactory serviceFactory =factory;
        User user = getAuthorizedUser();
        if (user!=null) {
            String id_product = req.getParameter("idProduct").trim();
            int id_prod = Integer.valueOf(id_product);
            ChoseProduct choseProduct = new ChoseProduct();
            ProductService productService = serviceFactory.getService(ProductService.class);
            Product product = productService.readById(id_prod);
            CartService cartService = serviceFactory.getService(CartService.class);

            List<ChoseProduct> choseProductsAll = cartService.getUserCart(user.getId());
            choseProduct.setProduct(product);
            ChoseProductService choseProductService= factory.getService(ChoseProductService.class);
            logic(req,response,cartService,user.getId(),choseProductService,choseProductsAll, choseProduct);
        }
    }

    abstract void  logic(HttpServletRequest request, HttpServletResponse response,CartService cartService,int user_id,ChoseProductService choseProductService,List<ChoseProduct>choseProductsAll,ChoseProduct choseProduct) throws IOException, DBException;
}
