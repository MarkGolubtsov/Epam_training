package action.cart;

import action.role.ajax.AuthorizeActionAjax;
import action.role.ajax.UserActionAjax;
import action.role.forward.AuthorizeActionForward;
import domain.ChoseProduct;
import domain.User;
import exception.DBException;
import service.CartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetCountCartAjaxAction extends AuthorizeActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException {
        User user = getAuthorizedUser();
        if ( user!=null) {
            CartService cartService = factory.getService(CartService.class);
            int count = 0;
            List<ChoseProduct> choseProducs = cartService.getUserCart(user.getId());
            for (ChoseProduct c :
                    choseProducs) {
                count = count + c.getCount();
            }
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(String.valueOf(count));
        }
    }
}
