package action;

import domain.RoleUser;
import domain.User;
import exception.DBException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends Action {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        Forward forward = new Forward("registration.jsp");
        String login =  request.getParameter("name");
        String password =  request.getParameter("password");
        String role =request.getParameter("role");
        String telephone = request.getParameter("tel");
        if (login!=null && password!=null && role!=null && telephone!=null) {
            UserService service = null;
            try {
                service = factory.getService(UserService.class);
            } catch (DBException e) {
                e.printStackTrace();
            }
            User user = new User();
            user.setName(login);
            user.setTelephone(telephone);
            user.setRoleUser(RoleUser.valueOf(role));
            user.setPassword(password);
            boolean res = service.registration(user);
            request.setAttribute("result", res);
        }
        return forward;
    }
}
