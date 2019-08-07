package action.cart;

import action.role.ajax.UserActionAjax;
import deserializer_json.OrderDataDeserializer;
import deserializer_json.OrderDataDeserializerJsonImpl;
import domain.*;
import exception.DBException;
import service.CartService;
import service.OrderService;
import service.OrderedProductService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class CreateOrderActionAjax extends UserActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException {
        String json =request.getParameter("order");
        OrderDataDeserializer orderDataDeserializer = new OrderDataDeserializerJsonImpl(json);
        OrderService orderService = factory.getService(OrderService.class);
        UserService userService = factory.getService(UserService.class);
        CartService cartService =factory.getService(CartService.class);
        OrderedProductService orderedProductService=factory.getService(OrderedProductService.class);

        int user_id=orderDataDeserializer.readUserId();
        User user = userService.findById(user_id);
        Order order = new Order();
        order.setUser(user);

        Calendar calendar = Calendar.getInstance();
        order.setDate(new Date(calendar.getTime().getTime()));

        TypeDelivery typeDelivery=orderDataDeserializer.readDeliveryType();
        order.setDelivery(typeDelivery);

        TypePay typePay=orderDataDeserializer.readTypePay();
        order.setType_pay(typePay);
        BigDecimal cost=orderDataDeserializer.readTotalCost();
        order.setTotal_price(cost);
        int order_id=orderService.save(order);
        List<Integer> choseProducts=orderDataDeserializer.readIdChoseProducts();
        for (int chose_product_id:
             choseProducts) {
            ChoseProduct choseProduct = new ChoseProduct();
            choseProduct.setId(chose_product_id);
            cartService.deleteFromUserCart(user_id,choseProduct);
            orderedProductService.addInOrder(order_id,choseProduct);
        }
    }
}
