package action.product;

import action.Action;
import domain.Product;
import exception.DBException;
import service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ActionProductList extends Action {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        ProductService service = null;
        try {
            service = factory.getService(ProductService.class);
        } catch (DBException e) {
            e.printStackTrace();
        }
        request.setAttribute("listProduct",service.read());
        return null;
    }
}
