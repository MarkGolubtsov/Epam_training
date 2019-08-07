package controller;
import action.Action;
import action.ActionWithForward;
import action.MainAction;
import domain.RoleUser;
import domain.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

public class SecurityFilter implements Filter {
    private static Logger logger = Logger.getLogger(SecurityFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
                Action action = (Action) httpRequest.getAttribute("action");
//            Set<Role> allowRoles = action.getAllowRoles();
            HttpSession session = httpRequest.getSession(false);
            User user = null;
            if (session != null) {
                user = (User) session.getAttribute("authorizedUser");
                action.setAuthorizedUser(user);
                String errorMessage = (String) session.getAttribute("SecurityFilterMessage");
                if (errorMessage != null) {
                    httpRequest.setAttribute("message", errorMessage);
                    session.removeAttribute("SecurityFilterMessage");
                }
            }
            Set<RoleUser> allowRoles = action.getAllowRoles();
            boolean canExecute = (allowRoles.size() == 0);
            if(user != null) {
                canExecute = canExecute || allowRoles.contains(user.getRoleUser());
            }
            if(canExecute) {
                chain.doFilter(request, response);
            }  else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/shop/login");
            }

        }
    }

    @Override
    public void destroy() {

    }
}
