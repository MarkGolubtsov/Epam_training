package action.admin;

import action.role.forward.AdminActionForward;
import exception.DBException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

public class GetAllUsers extends AdminActionForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException, URISyntaxException {
        UserService userService=factory.getService(UserService.class);
        request.setAttribute("listUsers",userService.readAll());
        return null;
    }
}
