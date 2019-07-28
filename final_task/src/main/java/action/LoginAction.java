package action;

import domain.RoleUser;
import domain.User;
import exception.DBException;
import org.apache.log4j.Logger;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginAction extends ActionWithForward {
    private static Logger logger = Logger.getLogger(LoginAction.class);
    private static Map<RoleUser, List<NavbarItem>> navbar = new ConcurrentHashMap<>();
    static {
        navbar.put(RoleUser.USER, new ArrayList<>(Arrays.asList(
                new NavbarItem("/shop/chose_product/list","Basket"),
                new NavbarItem("/shop/search/delivery/list", "Delivery"),
                new NavbarItem("/shop/search/delivery/form", "Create delivery"),
                new NavbarItem("/shop/search/order/list", "Order")
        )));
        navbar.put(RoleUser.COURIER, new ArrayList<>(Arrays.asList(
                new NavbarItem("/shop/deliverys/list", "читатели")
        )));
        navbar.put(RoleUser.ADMIN, new ArrayList<>(Arrays.asList(
                new NavbarItem("/shop/author/list", "авторы")
        )));
    }
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        String login = request.getParameter("name");
        String password = request.getParameter("password");
        if (login!=null && password!=null) {
            logger.debug("not null");
            UserService service = null;
            try {
                service = factory.getService(UserService.class);
            } catch (DBException e) {
                e.printStackTrace();
            }

            User user = service.signIn(login, password);
            if (user != null) {
                logger.debug("sigIn");
                setAuthorizedUser(user);
                HttpSession session = request.getSession();
                session.setAttribute("authorizedUser", user);
                session.setAttribute("menu",navbar.get(user.getRoleUser()));
                return new Forward("/shop/main");
            }
            return  new Forward("/shop/registration");
        }
        return null;
    }
}
