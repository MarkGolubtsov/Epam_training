package action.chose_product;

import action.Action;
import controller.ActionFilter;
import domain.ChoseProduct;
import domain.User;
import exception.DBException;
import org.apache.log4j.Logger;
import service.ChoseProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ActionUserBasket extends Action {
    private static Logger logger = Logger.getLogger(ActionUserBasket.class);
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        User user = getAuthorizedUser();
        logger.info("get basket ,UserId="+user.getId());
        ChoseProductService choseProductService = factory.getService(ChoseProductService.class);
        List<ChoseProduct> choseProductList =choseProductService.findByUserId(user.getId());
        logger.debug("Size basket"+choseProductList.size());
        request.setAttribute("listChoseProduct",choseProductList);
        return null;
    }
}
