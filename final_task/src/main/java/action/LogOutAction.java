package action;

import exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutAction extends ActionWithForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
      //  logger.info(String.format("role \"%s\" is logged out", role.getLogin()));
        request.getSession(false).invalidate();
        return new Forward("/shop/login");
    }
}
