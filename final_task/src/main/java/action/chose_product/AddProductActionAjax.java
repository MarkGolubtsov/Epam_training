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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddProductActionAjax extends ProductAjaxAction{
    private static Logger logger = Logger.getLogger(AddProductActionAjax.class);


    @Override
    void logic( HttpServletResponse resp,ChoseProductService choseProductService,List<ChoseProduct>choseProductsAll,ChoseProduct choseProduct) throws IOException {
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
