package action;

import domain.RoleUser;
import domain.User;
import exception.DBException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends ActionWithForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        String login =  request.getParameter("name");
        String password =  request.getParameter("password");
        String role =request.getParameter("role");
        String telephone = request.getParameter("tel");
        if (login!=null && password!=null && role!=null && telephone!=null) {
            Forward forward = new Forward("/shoplogin");
            UserService service = null;
            service = factory.getService(UserService.class);
            User user = new User();
            user.setName(login);
            user.setTelephone(telephone);
            user.setRoleUser(RoleUser.valueOf(role));
            user.setPassword(password);
            boolean res = service.registration(user);
            if (res) {
                return forward;
            } else {
                request.setAttribute("result", res);
                return null;
            }
        }
        return null;
    }
}
