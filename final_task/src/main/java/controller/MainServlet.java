package controller;

import action.Action;
import action.LoginAction;
import dao.mysql.DaoFactoryImpl;
import dao.pool.ConnectionPool;
import domain.RoleUser;
import domain.User;
import exception.DBException;

import org.apache.log4j.*;
import service.ServiceFactory;
import service.UserService;
import service.implement.ServiceFactoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

@MultipartConfig
@WebServlet
public class MainServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(MainServlet.class);


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
            ConnectionPool.getInstance().init(DB_DRIVER_CLASS, DB_URL, DB_USER, DB_PASSWORD, DB_POOL_START_SIZE, DB_POOL_MAX_SIZE, DB_POOL_CHECK_CONNECTION_TIMEOUT);
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
        Action action = (Action)request.getAttribute("action");
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
        action.setFactory(ServiceFactoryImpl.INSTANCE);
        System.out.println(action.getName());
        Action.Forward forward = null;
        try {
           forward=action.exec(request,response);
        } catch (DBException e) {
            e.printStackTrace();
        }
        if(session != null && forward != null && !forward.getAttributes().isEmpty()) {
            session.setAttribute("redirectedData", forward.getAttributes());
        }
        String requestedUri = request.getRequestURI();
        if(forward != null && forward.isRedirect()) {
            String redirectedUri = request.getContextPath() + forward.getForward();
            logger.debug(String.format("Request for URI \"%s\" id redirected to URI \"%s\"", requestedUri, redirectedUri));
            response.sendRedirect(redirectedUri);
        } else {
            String jspPage;
            if(forward != null) {
                jspPage = forward.getForward();
            } else {
                jspPage = action.getName() + ".jsp";
            }
            jspPage = "/WEB-INF/jsp" + jspPage;
            logger.debug(String.format("Request for URI \"%s\" is forwarded to JSP \"%s\"", requestedUri, jspPage));
            getServletContext().getRequestDispatcher(jspPage).forward(request, response);
        }

    }

}
