package action.admin.order;

import action.role.ajax.AdminActionAjax;
import domain.Order;
import exception.DBException;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CheckAvailabilityOrder extends AdminActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer user_id =Integer.valueOf(request.getParameter("user_id"));
        OrderService orderService=factory.getService(OrderService.class) ;
        List<Order> orders =orderService.readByUserId(user_id);
        String res="yes";
        if ( orders==null || orders.isEmpty())
        {
            res="no";
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(res);
    }
}
