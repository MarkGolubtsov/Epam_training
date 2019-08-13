package action.admin;

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
import java.math.BigDecimal;

public class CreateDelivery extends AdminActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer user_id =Integer.valueOf(request.getParameter("user_id"));
        Integer order_id =Integer.valueOf(request.getParameter("order_id"));
        Integer courier_id =Integer.valueOf(request.getParameter("courier_id"));
        if (user_id>0 && order_id>0 && courier_id>0) {
            Delivery delivery = new Delivery();
            User user = new User();
            Order order= new Order();
            User courier = new User();
            user.setId(user_id);
            courier.setId(courier_id);
            order.setId(order_id);
            delivery.setUser(user);
            delivery.setOrder(order);
            delivery.setCourier(courier);
            DeliveryService deliveryService=factory.getService(DeliveryService.class);
            deliveryService.save(delivery);
        } else {
            throw new DBException("id<0");
        }

    }
}
