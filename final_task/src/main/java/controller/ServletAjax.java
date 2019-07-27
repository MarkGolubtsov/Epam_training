package controller;

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
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req,resp);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String id_product = req.getParameter("idProduct").trim();
        HttpSession session = req.getSession(false);
        if (session!=null)
        {
            ServiceFactory serviceFactory = ServiceFactoryImpl.INSTANCE;
            User user = (User) session.getAttribute("authorizedUser");
            int id_prod=Integer.valueOf(id_product);
            ChoseProduct choseProduct = new ChoseProduct();
            ProductService productService = serviceFactory.getService(ProductService.class);
            Product product =productService.readById(id_prod);
            choseProduct.setProduct(product);
            choseProduct.setUser(user);
            ChoseProductService choseProductService = serviceFactory.getService(ChoseProductService.class);
            List<ChoseProduct> choseProductsAll =choseProductService.findByUserId(user.getId());
            boolean flagInc = false;
            for (ChoseProduct c:
                    choseProductsAll) {
                if (c.getProduct().getId() == choseProduct.getProduct().getId()) {
                    int count =c.getCount()+1;
                    c.setCount(count);
                    choseProductService.update(c);
                    flagInc=true;
                }
            }
            if (!flagInc) {
                choseProduct.setCount(1);
                choseProductService.save(choseProduct);
            }
        }

    }


}
