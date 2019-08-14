package action.courier;

import action.role.forward.CourierActionForward;
import domain.User;
import exception.DBException;
import service.DeliveryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

public class GetAllDelivery extends CourierActionForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException, URISyntaxException {
        User user = getAuthorizedUser();
        DeliveryService deliveryService = factory.getService(DeliveryService.class);
        request.setAttribute("listDelivery",deliveryService.readByCourierId(user.getId()));
        return null;
    }
}
