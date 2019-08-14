package action.courier;

import action.role.ajax.CourierActionAjax;
import domain.ChoseProduct;
import domain.Delivery;
import domain.Order;
import domain.User;
import exception.DBException;
import service.ChoseProductService;
import service.DeliveryService;
import service.OrderService;
import service.OrderedProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DoneOrder extends CourierActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer order_id =Integer.valueOf(request.getParameter("order_id"));
        Integer courier_id =Integer.valueOf(request.getParameter("courier_id"));
        if(getAuthorizedUser().getId() == courier_id){
            Order order=new Order();
            order.setId(order_id);
            User user = new User();
            user.setId(courier_id);
            Delivery delivery=new Delivery();
            delivery.setOrder(order);
            delivery.setCourier(user);
            DeliveryService deliveryService=factory.getService(DeliveryService.class);
            deliveryService.delete(delivery);
            OrderedProductService orderedProductService = factory.getService(OrderedProductService.class);

            List<ChoseProduct> list=orderedProductService.readOrderProduct(order_id);
            ChoseProductService choseProductService=factory.getService(ChoseProductService.class);
            for (ChoseProduct c:
                 list) {
                orderedProductService.delete(order_id,c);
                choseProductService.delete(c);
            }
            OrderService orderService = factory.getService(OrderService.class);
            orderService.deleteById(order_id);
        }

    }
}
