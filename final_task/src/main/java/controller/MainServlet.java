package controller;

import action.Action;
import action.ActionAjax;
import action.ActionWithForward;
import dao.mysql.DaoFactoryImpl;
import dao.pool.ConnectionPool;
import exception.DBException;

import org.apache.log4j.*;
import service.ServiceFactory;
import service.implement.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@MultipartConfig
@WebServlet
public class MainServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(MainServlet.class);

    private Lock locker;
    public static final String LOG_FILE_NAME = "log.txt";
    public static final Level LOG_LEVEL = Level.ALL;
    public static final String LOG_MESSAGE_FORMAT = "%n%d%n%p\t%C.%M:%L%n%m%n";

    public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/shop?serverTimezone=EST5EDT&verifyServerCertificate=false&useSSL=true";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";
    public static final int DB_POOL_START_SIZE = 10;
    public static final int DB_POOL_MAX_SIZE = 1000;
    public static final int DB_POOL_CHECK_CONNECTION_TIMEOUT =0;
    public void init() {
        try {
            Logger root = Logger.getRootLogger();
            Layout layout = new PatternLayout(LOG_MESSAGE_FORMAT);
            root.addAppender(new FileAppender(layout, LOG_FILE_NAME, true));
            root.addAppender(new ConsoleAppender(layout));
            root.setLevel(LOG_LEVEL);
            ConnectionPool.INSTANCE.init(DB_DRIVER_CLASS, DB_URL, DB_USER, DB_PASSWORD, DB_POOL_START_SIZE, DB_POOL_MAX_SIZE, DB_POOL_CHECK_CONNECTION_TIMEOUT);
            locker=ConnectionPool.INSTANCE.getLock();
        } catch (DBException | IOException e) {
            e.printStackTrace();
        }
    }
    public ServiceFactory getFactory() throws DBException{
        ServiceFactoryImpl.INSTANCE.setDaoFactory(DaoFactoryImpl.INSTANСE);
        return  ServiceFactoryImpl.INSTANCE;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request,response);
    }
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug("+++++");
        Action action1 = (Action) request.getAttribute("action");
        HttpSession session = request.getSession(false);
        if(session != null) {
            @SuppressWarnings("unchecked")
            Map<String, Object> attributes = (Map<String, Object>)session.getAttribute("redirectedData");
            if(attributes != null) {
                for(String key : attributes.keySet()) {
                    request.setAttribute(key, attributes.get(key));
                }
                session.removeAttribute("redirectedData");
            }
        }
        ServiceFactoryImpl.INSTANCE.setDaoFactory(DaoFactoryImpl.INSTANСE);
        action1.setFactory(ServiceFactoryImpl.INSTANCE);
        if(action1 instanceof ActionWithForward) {
            ActionWithForwardDo(action1, request, response, session);
            return;
        }
            if(action1 instanceof ActionAjax){
                ActionAjax actionAjax = (ActionAjax)action1;
                try {
                    System.out.println("Action name"+actionAjax.getName());
                    actionAjax.exec(request,response);
                    return;
                } catch (DBException e) {
                    logger.error(e.getMessage());
                    request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error/error.jsp").forward(request, response);
                }
            }



    }
    private void ActionWithForwardDo(Action action1,HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException, ServletException {
        ActionWithForward action = (ActionWithForward)action1;
        ActionWithForward.Forward forward = null;
        try {
            try {
                forward = action.exec(request, response);
            } catch (URISyntaxException e) {
               logger.error(e.getMessage());
            }
        } catch (DBException e) {
           logger.error(e.getMessage());
            request.setAttribute("error", "Ошибка обработки данных");
            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/error/error.jsp").forward(request, response);
        }
        if (session != null && forward != null && !forward.getAttributes().isEmpty()) {
            session.setAttribute("redirectedData", forward.getAttributes());
        }
        String requestedUri = request.getRequestURI();
        if (forward != null && forward.isRedirect()) {
            String redirectedUri = request.getContextPath() + forward.getForward();
            logger.debug(String.format("Request for URI \"%s\" id redirected to URI \"%s\"", requestedUri, redirectedUri));
            response.sendRedirect(redirectedUri);

        } else {
            String jspPage;
            if (forward != null) {
                jspPage = forward.getForward();
            } else {
                jspPage = action.getName() + ".jsp";
            }
            String buf =jspPage;
            jspPage = "/WEB-INF/jsp" + jspPage;
            logger.debug(String.format("Request for URI \"%s\" is forwarded to JSP \"%s\"", requestedUri, jspPage));
            getServletContext().getRequestDispatcher(jspPage).forward(request, response);
        }
    }

}
