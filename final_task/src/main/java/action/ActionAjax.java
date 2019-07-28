package action;

import exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ActionAjax  extends Action {
    abstract public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException;
}
