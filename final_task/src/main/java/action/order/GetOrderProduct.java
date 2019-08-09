package action.order;

import action.role.ajax.AuthorizeActionAjax;
import com.google.gson.Gson;
import domain.ChoseProduct;
import exception.DBException;
import service.OrderedProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetOrderProduct extends AuthorizeActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException {
       Integer order_id=Integer.valueOf(request.getParameter("Order_id"));
        OrderedProductService orderedProductService = factory.getService(OrderedProductService.class);
        List<ChoseProduct> list =orderedProductService.readOrderProduct(order_id);
        Gson gson = new Gson();
        String result = gson.toJson(list);
        response.setContentType("application/json");
        response.getWriter().write(result);
    }
}
