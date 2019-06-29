package controller;


import dao.FilesWorker;
import entity.Flower;
import parser.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
//http://localhost:8089/task04v5_war_exploded/index.jsp
@MultipartConfig
@WebServlet
public class Controller extends HttpServlet {

    SAXParser parserSAX=SAXParser.getInstance();
    DOMParser parserDOM = DOMParser.getInstance();
    StAXParser parserSTAX= StAXParser.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Flower> listSax = null;
        List<Flower> listStax = null;
        List<Flower> listDom = null;

        FilesWorker filesWorker =new FilesWorker();

        filesWorker.save(req);
        String path =filesWorker.getCorrectFilePath();

        try {
                listDom = parserDOM.getData(path);
                listSax = parserSAX.getData(path);
                listStax = parserSTAX.getData(path);
            } catch (ParserException e) {

            }
            req.setAttribute("listDom", listDom);
            req.setAttribute("listSax", listSax);
            req.setAttribute("listStax", listStax);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("result.jsp");
            requestDispatcher.forward(req, resp);


    }

}
