package controller.ajax;

import dao.pool.ConnectionPool;
import domain.ChoseProduct;
import domain.Product;
import domain.User;
import exception.DBException;
import service.ChoseProductService;
import service.ProductService;
import service.ServiceFactory;
import service.implement.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet
public class ServletAjax extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req,resp);
        } catch (DBException e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req,resp);
        } catch (DBException e) {
            System.out.println(e);
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws DBException, IOException {

    }


}
