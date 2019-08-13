package action.admin.order;

import action.role.ajax.AdminActionAjax;
import com.google.gson.Gson;
import domain.Order;
import exception.DBException;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUserOrders extends AdminActionAjax {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer id =Integer.valueOf(request.getParameter("user_id"));
        OrderService orderService = factory.getService(OrderService.class);
        List<Order> orders = orderService.readByUserId(id);
        Gson gson = new Gson();
        String result = gson.toJson(orders);
        response.setContentType("application/json");
        response.getWriter().write(result);
    }
}
