package action;

import exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction extends ActionWithForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        return null;
    }
}
