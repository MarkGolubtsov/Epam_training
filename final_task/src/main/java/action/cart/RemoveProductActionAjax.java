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

public class RemoveProductActionAjax extends ProductAjaxAction {
    private static Logger logger = Logger.getLogger(AddProductActionAjax.class);

    @Override
    void logic(HttpServletRequest request,HttpServletResponse resp, CartService cartService, int user_id, ChoseProductService choseProductService, List<ChoseProduct>choseProductsAll, ChoseProduct choseProduct) throws IOException, DBException {
        String id_chose = request.getParameter("idChoseProduct").trim();
        int id = Integer.valueOf(id_chose);
        choseProduct.setId(id);
        int count=-1;
        for (ChoseProduct c :
                choseProductsAll) {
            if (c.getProduct().getId() == choseProduct.getProduct().getId()) {
                count = c.getCount();
                if (count>0) {
                    count=count-1;
                }
                c.setCount(count);
                try {
                    choseProductService.update(c);
                } catch (DBException e) {
                    return;
                }
            }
        }
        if (count==0) {
            cartService.deleteFromUserCart(user_id,choseProduct);
            choseProductService.delete(choseProduct);
        }
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(String.valueOf(count));
    }
}
