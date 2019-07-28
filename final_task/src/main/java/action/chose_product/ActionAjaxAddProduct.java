package action.chose_product;

import action.ActionAjax;
import domain.ChoseProduct;
import domain.Product;
import domain.User;
import exception.DBException;
import org.apache.log4j.Logger;
import service.ChoseProductService;
import service.ProductService;
import service.ServiceFactory;
import service.implement.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ActionAjaxAddProduct extends ActionAjax {
    private static Logger logger = Logger.getLogger(ActionAjaxAddProduct.class);
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, DBException {
            ServiceFactory serviceFactory =factory;
            User user = getAuthorizedUser();
            String id_product = req.getParameter("idProduct").trim();
            int id_prod = Integer.valueOf(id_product);
            ChoseProduct choseProduct = new ChoseProduct();
        ProductService productService = serviceFactory.getService(ProductService.class);
        Product product = productService.readById(id_prod);
        ChoseProductService choseProductService = serviceFactory.getService(ChoseProductService.class);
        List<ChoseProduct> choseProductsAll  = choseProductService.findByUserId(user.getId());

            choseProduct.setProduct(product);
            choseProduct.setUser(user);
            int count=1;
            boolean flagInc = false;
            for (ChoseProduct c :
                    choseProductsAll) {
                if (c.getProduct().getId() == choseProduct.getProduct().getId()) {
                    count = c.getCount() + 1;
                    c.setCount(count);
                    try {
                        choseProductService.update(c);
                    } catch (DBException e) {
                    return;
                    }
                    flagInc = true;
                }
            }
            if (!flagInc) {
                choseProduct.setCount(1);
                try {
                    choseProductService.save(choseProduct);
                } catch (DBException e) {
                    return;
                }

            }
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(String.valueOf(count));
        }

}
