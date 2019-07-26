package action;

import domain.User;
import exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutAction extends Action {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
      //  logger.info(String.format("user \"%s\" is logged out", user.getLogin()));
        request.getSession(false).invalidate();
        return new Forward("/login.html");
    }
}
