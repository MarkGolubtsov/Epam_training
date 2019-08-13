package action.admin;

import action.role.forward.AdminActionForward;
import domain.*;
import exception.DBException;
import service.AddressService;
import service.DeliveryService;
import service.OrderService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class GetDataForCreateDelivery extends AdminActionForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException, URISyntaxException {
        OrderService orderService=factory.getService(OrderService.class);
        DeliveryService deliveryService=factory.getService(DeliveryService.class);
        List<Delivery> deliveries=deliveryService.findAll();
        UserService userService=factory.getService(UserService.class);
        List<User> couriers=userService.findByRole(RoleUser.COURIER);
        List<Order> orderList=orderService.readByDelivery(TypeDelivery.COURIER);
        List<Integer> deliveries_id=new ArrayList<>();
        List<Order> resultOrder = new LinkedList<>();
        for (Delivery d:
            deliveries) {
            deliveries_id.add(d.getOrder().getId());
        }
        for (Order o:
             orderList) {
            if (!deliveries_id.contains(o.getId())) {
                resultOrder.add(o);
            }
        }

        request.setAttribute("Orders",resultOrder);
        request.setAttribute("Couriers",couriers);
        return null;
    }
}
