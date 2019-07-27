package controller;
import action.*;
import action.Registration;
import action.chose_product.ActionCreateChoseProduct;
import action.chose_product.ActionUserBasket;
import action.product.ActionProductList;
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

        actions.put("/product/list", ActionProductList.class);

        actions.put("/chose_product/add", ActionCreateChoseProduct.class);
        actions.put("/chose_product/list", ActionUserBasket.class);
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
            int beginAction = contextPath.length();
            int endAction = uri.lastIndexOf('.');
            String actionName;
            if(endAction >= 0) {
                actionName = uri.substring(beginAction, endAction);
            } else {
                actionName = uri.substring(beginAction);
            }
            Class<? extends Action> actionClass = actions.get(actionName);
            try {
                Action action = actionClass.newInstance();
                action.setName(actionName);
                httpRequest.setAttribute("action", action);
                chain.doFilter(request, response);
            } catch (InstantiationException | IllegalAccessException | NullPointerException e) {
               logger.error("It is impossible to create action handler object", e);
//                httpRequest.setAttribute("error", String.format("Запрошенный адрес %s не может быть обработан сервером", uri));
//                httpRequest.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            }
        } else {
           logger.error("It is impossible to use HTTP filter");
//            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
