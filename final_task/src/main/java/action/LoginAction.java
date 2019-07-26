package action;

import domain.RoleUser;
import domain.User;
import exception.DBException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginAction extends Action {
    private static Map<RoleUser, List<NavbarItem>> navbar = new ConcurrentHashMap<>();
    static {
        navbar.put(RoleUser.USER, new ArrayList<>(Arrays.asList(
                new NavbarItem("/main.html", "Главная"),
                new NavbarItem("/search/delivery/list.html", "Доставки"),
                new NavbarItem("/search/delivery/form.html", "Создать доставку"),
                new NavbarItem("/search/order/list.html", "Заказы")
        )));
        navbar.put(RoleUser.COURIER, new ArrayList<>(Arrays.asList(
                new NavbarItem("/deliverys/list.html", "читатели")
        )));
        navbar.put(RoleUser.ADMIN, new ArrayList<>(Arrays.asList(
                new NavbarItem("/author/list.html", "авторы")
        )));
    }
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        String login = request.getParameter("name");
        String password = request.getParameter("password");
        if (login!=null && password!=null) {
            UserService service = null;
            try {
                service = factory.getService(UserService.class);
            } catch (DBException e) {
                e.printStackTrace();
            }
            User user = service.signIn(login, password);
            if (user != null) {
                setAuthorizedUser(user);
                HttpSession session = request.getSession();
                session.setAttribute("authorizedUser", user);
                session.setAttribute("menu",navbar.get(user.getRoleUser()));
                return new Forward("/main.html");
            }
            return  new Forward("/registration.html");
        }
        return null;
    }
}
