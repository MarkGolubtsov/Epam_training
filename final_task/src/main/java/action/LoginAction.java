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
                new NavbarItem("/shop/chose_product/list","Cart",null),
                new NavbarItem("/shop/search/delivery/list", "Delivery",null),
                new NavbarItem("/shop/order/list", "Orders",null),
                new NavbarItem("/shop/user/edit","Profile","person")
        )));

        navbar.put(RoleUser.COURIER, new ArrayList<>(Arrays.asList(
                new NavbarItem("/shop/delivery/list", "Delivery",null)
        )));
        navbar.put(RoleUser.ADMIN, new ArrayList<>(Arrays.asList(
                new NavbarItem("/shop/user/list", "Users","people"),
                new NavbarItem("/shop/delivery/create", "Unassigned_delivery",null),
                new NavbarItem("/shop/product/create", "Create_Product",null)
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
                session.setAttribute("menu",navbar.get(user.getRole()));
                return new Forward("/shop/main");
            }
            return  null;
        }
        return null;
    }
}
