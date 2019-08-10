package action.lang;

import action.ActionAjax;
import exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetZHLang extends ActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        request.getSession().removeAttribute("language");
        request.getSession().setAttribute("language" , "zh");
    }
}
