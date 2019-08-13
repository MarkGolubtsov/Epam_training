package action.admin.delivery;

import action.role.ajax.AdminActionAjax;
import com.google.gson.Gson;
import domain.Delivery;
import exception.DBException;
import service.DeliveryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetDeliveryCourier extends AdminActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer courier_id =Integer.valueOf(request.getParameter("courier_id"));
        DeliveryService deliveryService = factory.getService(DeliveryService.class);
        List<Delivery> deliveries=deliveryService.readByCourierId(courier_id);
        Gson gson = new Gson();
        String json=gson.toJson(deliveries);;
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
