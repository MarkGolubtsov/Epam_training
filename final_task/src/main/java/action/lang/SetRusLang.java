package action.lang;

import action.ActionAjax;
import exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetRusLang extends ActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response)  {
            request.getSession().removeAttribute("language");
            request.getSession().setAttribute("language" , "ru");
    }


}
