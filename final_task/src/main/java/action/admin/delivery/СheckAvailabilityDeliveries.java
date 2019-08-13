package action.admin.delivery;

import action.role.ajax.AdminActionAjax;
import domain.Delivery;
import exception.DBException;
import service.DeliveryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class СheckAvailabilityDeliveries extends AdminActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer courier_id=Integer.valueOf(request.getParameter("courier_id"));
        DeliveryService deliveryService=factory.getService(DeliveryService.class) ;
        List<Delivery> deliveries =deliveryService.readByCourierId(courier_id);
        String res="yes";
        if ( deliveries==null || deliveries.isEmpty())
        {
            res="no";
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(res);
    }
}
