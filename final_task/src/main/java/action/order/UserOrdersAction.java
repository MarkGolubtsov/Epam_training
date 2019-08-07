package action.order;

import action.role.forward.UserActionForward;
import domain.Order;
import domain.User;
import exception.DBException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserOrdersAction  extends UserActionForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        User user = getAuthorizedUser();
        if (user!=null) {
            OrderService orderService = factory.getService(OrderService.class);
            List<Order> orderList = orderService.readByUserId(user.getId());
            request.setAttribute("listOrder", orderList);
            request.setAttribute("userId", user.getId());
        }
        return null;
    }
}
