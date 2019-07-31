package action.chose_product;

import action.ActionWithForward;
import domain.ChoseProduct;
import domain.User;
import exception.DBException;
import org.apache.log4j.Logger;
import service.CartService;
import service.ChoseProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserCartAction extends ActionWithForward {
    private static Logger logger = Logger.getLogger( UserCartAction.class);
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        User user = getAuthorizedUser();
        logger.info("get basket ,UserId="+user.getId());
        CartService cartService = factory.getService(CartService.class);
        List<ChoseProduct> choseProductList =cartService.getUserCart(user.getId());
        logger.debug("Size basket"+choseProductList.size());
        request.setAttribute("listChoseProduct",choseProductList);
        return null;
    }
}
