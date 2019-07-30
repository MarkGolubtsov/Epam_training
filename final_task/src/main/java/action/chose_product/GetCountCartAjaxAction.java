package action.chose_product;

import action.ActionAjax;
import domain.ChoseProduct;
import domain.User;
import exception.DBException;
import service.ChoseProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetCountCartAjaxAction extends ActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException {
        User user = getAuthorizedUser();
        if ( user!=null) {
            ChoseProductService choseProductService = factory.getService(ChoseProductService.class);
            int count = 0;
            List<ChoseProduct> choseProducs = choseProductService.findByUserId(user.getId());
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
