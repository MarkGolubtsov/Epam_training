package controller;

import action.Registration;
import action.*;
import action.admin.CreateDelivery;
import action.admin.GetAddressUser;
import action.admin.GetAllUsers;
import action.admin.GetDataForCreateDelivery;
import action.admin.delivery.DeleteDelivery;
import action.admin.delivery.GetDeliveryCourier;
import action.admin.delivery.СheckAvailabilityDeliveries;
import action.admin.order.CheckAvailabilityOrder;
import action.admin.order.DeleteOrder;
import action.admin.order.GetUserOrders;
import action.admin.product.CreateProduct;
import action.admin.set_role.MakeAdmin;
import action.admin.set_role.MakeCourier;
import action.admin.set_role.MakeUser;
import action.cart.*;
import action.courier.DoneOrder;
import action.courier.GetAllDelivery;
import action.lang.GetLang;
import action.lang.SetEngLang;
import action.lang.SetRusLang;
import action.lang.SetZHLang;
import action.order.GetOrderProduct;
import action.order.UserOrdersAction;
import action.product.ProductListAction;
import action.user.GetInfoUser;
import action.user.SaveUserInfo;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionFilter implements Filter {
    private static Map<String, Class<? extends Action>> actions = new ConcurrentHashMap<>();
    private static Logger logger = Logger.getLogger(ActionFilter.class);
    static {
        actions.put("/login", LoginAction.class);
        actions.put("/registration", Registration.class);
        actions.put("/main", MainAction.class);
        actions.put("/logout", LogOutAction.class);

        actions.put("/product/list", ProductListAction.class);

        actions.put("/chose_product/list",UserCartAction.class);

        actions.put("/getCountProductInCart", GetCountCartAjaxAction.class);
        actions.put("/addInCart", AddProductActionAjax.class);
        actions.put("/removeOutCart", RemoveProductActionAjax.class);

        actions.put("/createOrder", CreateOrderActionAjax.class);
        actions.put("/order/list", UserOrdersAction.class);

        actions.put("/user/edit", GetInfoUser.class);
        actions.put("/userSaveInfo", SaveUserInfo.class);
        actions.put("/getOrderProduct", GetOrderProduct.class);

        actions.put("/SetRusLang", SetRusLang.class);
        actions.put("/SetEngLang", SetEngLang.class);
        actions.put("/SetZHLang", SetZHLang.class);

        actions.put("/GetLang", GetLang.class);

        actions.put("/user/list", GetAllUsers.class);
        actions.put("/MakeAdmin", MakeAdmin.class);
        actions.put("/MakeUser", MakeUser.class);
        actions.put("/MakeCourier", MakeCourier.class);
        actions.put("/GetUserOrders", GetUserOrders.class);
        actions.put("/DeleteOrder", DeleteOrder.class);
        actions.put("/CheckAvailabilityOrder", CheckAvailabilityOrder.class);
        actions.put("/delivery/create", GetDataForCreateDelivery.class);
        actions.put("/GetAddressOrders", GetAddressUser.class);
        actions.put("/CreateDelivery",  CreateDelivery.class);
        actions.put("/GetDeliveryCourier",  GetDeliveryCourier.class);
        actions.put("/DeleteDelivery",  DeleteDelivery.class);
        actions.put("/CheckAvailabilityDeliveries",   СheckAvailabilityDeliveries.class);
        actions.put("/product/create",  CreateProduct.class);
        actions.put("/delivery/list", GetAllDelivery.class);
        actions.put("/DoneOrder", DoneOrder.class);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            String contextPath = httpRequest.getContextPath();
            String uri = httpRequest.getRequestURI();
            logger.debug(String.format("Starting of processing of request for URI \"%s\"", uri));
            int beginAction = contextPath.length()+5;
            int endAction = uri.length();
            String actionName;
            if(endAction >= 0) {
                actionName = uri.substring(beginAction, endAction);
            } else {
                actionName = uri.substring(beginAction);
            }
            Class<? extends Action> actionClass = actions.get(actionName);
            try {
                 Action actionFinal= actionClass.newInstance();
                System.out.println("Forward?"+(actionFinal instanceof ActionWithForward));
                System.out.println("Ajax?"+(actionFinal instanceof ActionAjax));
                actionFinal.setName(actionName);
                logger.debug("Action name="+actionName);
                httpRequest.setAttribute("action", actionFinal);
                logger.debug("SetAttribute");
                chain.doFilter(request, response);
            } catch (InstantiationException | IllegalAccessException | NullPointerException e) {
               logger.error("It is impossible to create action handler object", e);
                httpRequest.setAttribute("error", String.format("Requested address "+uri+" cannot be processed by server"));
                request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error/error.jsp").forward(request, response);
            }
        } else {
           logger.error("It is impossible to use HTTP filter");
            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error/error.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
