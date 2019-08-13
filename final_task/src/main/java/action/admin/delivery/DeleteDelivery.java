package action.admin.delivery;

import action.role.ajax.AdminActionAjax;
import domain.Delivery;
import domain.Order;
import domain.User;
import exception.DBException;
import service.DeliveryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDelivery extends AdminActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer order_id =Integer.valueOf(request.getParameter("order_id"));
        Integer courier_id =Integer.valueOf(request.getParameter("courier_id"));
        Delivery delivery=new Delivery();
        Order order=new Order();
        order.setId(order_id);
        User user=new User();
        user.setId(courier_id);
        delivery.setCourier(user);
        delivery.setOrder(order);
        DeliveryService deliveryService = factory.getService(DeliveryService.class);
        deliveryService.delete(delivery);
    }
}
