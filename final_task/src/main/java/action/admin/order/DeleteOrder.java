package action.admin.order;

import action.role.ajax.AdminActionAjax;
import domain.ChoseProduct;
import exception.DBException;
import service.ChoseProductService;
import service.OrderService;
import service.OrderedProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteOrder extends AdminActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer id =Integer.valueOf(request.getParameter("order_id"));
        OrderService orderService = factory.getService(OrderService.class);
        OrderedProductService orderedProductService = factory.getService(OrderedProductService.class);
        List<ChoseProduct> choseProducts=orderedProductService.readOrderProduct(id);
        ChoseProductService choseProductService= factory.getService(ChoseProductService.class);
        for (ChoseProduct c:
             choseProducts) {
            orderedProductService.delete(id,c);
            choseProductService.delete(c);
        }
        orderService.deleteById(id);
    }
}
