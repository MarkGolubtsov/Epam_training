package action.product;

import action.ActionWithForward;
import exception.DBException;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionProductList extends ActionWithForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        ProductService service = null;
        service = factory.getService(ProductService.class);
        request.setAttribute("listProduct",service.read());
        return null;
    }
}
