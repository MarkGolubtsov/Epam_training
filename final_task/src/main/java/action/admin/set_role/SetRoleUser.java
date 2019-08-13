package action.admin.set_role;

import action.role.ajax.AdminActionAjax;
import domain.RoleUser;
import domain.User;
import exception.DBException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class SetRoleUser extends AdminActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer id =Integer.valueOf(request.getParameter("user_id"));
        UserService userService = factory.getService(UserService.class);
        User user =userService.findById(id);
        setRole(user);
        userService.update(user);
    }
    abstract void setRole(User user);
}
