package action.cart;

import domain.ChoseProduct;
import exception.DBException;
import org.apache.log4j.Logger;
import service.CartService;
import service.ChoseProductService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddProductActionAjax extends ProductAjaxAction {
    private static Logger logger = Logger.getLogger(AddProductActionAjax.class);
    @Override
    void logic(HttpServletRequest request, HttpServletResponse resp,CartService cartService,int user_id,ChoseProductService choseProductService,List<ChoseProduct>choseProductsAll,ChoseProduct choseProduct) throws IOException {
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
               Integer integer= choseProductService.save(choseProduct);
                choseProduct.setId(integer);
                cartService.addInUserCart(user_id,choseProduct);

            } catch (DBException e) {
                return;
            }

        }
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(String.valueOf(count));
    }
}
