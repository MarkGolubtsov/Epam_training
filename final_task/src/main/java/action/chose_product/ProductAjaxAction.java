package action.chose_product;

import action.ActionAjax;
import domain.ChoseProduct;
import domain.Product;
import domain.User;
import exception.DBException;
import service.ChoseProductService;
import service.ProductService;
import service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public abstract class ProductAjaxAction extends ActionAjax {
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
            ChoseProductService choseProductService = serviceFactory.getService(ChoseProductService.class);
            List<ChoseProduct> choseProductsAll = choseProductService.findByUserId(user.getId());

            choseProduct.setProduct(product);
            choseProduct.setUser(user);
            logic(response, choseProductService, choseProductsAll, choseProduct);
        }
    }

    abstract void  logic( HttpServletResponse response,ChoseProductService choseProductService,List<ChoseProduct>choseProductsAll,ChoseProduct choseProduct) throws IOException, DBException;
}
