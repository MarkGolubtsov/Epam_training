package action.admin.product;

import action.role.forward.AdminActionForward;
import domain.Product;
import exception.DBException;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Base64;

public class CreateProduct extends AdminActionForward {

    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String coststr = request.getParameter("cost");
        if (name!=null&& type!=null && coststr!=null) {
            Part filePart = request.getPart("file");
            String default_name =filePart.getSubmittedFileName();
            if (coststr.matches("[0-9]+")&& default_name!=null && default_name.matches("(.*)\\.(png|jpeg|jpg)$") && name.matches("[a-zA-Z ]+") && type.matches("[a-zA-Z ]+")) {
                BigDecimal cost=BigDecimal.valueOf(Long.parseLong(coststr));
//                int i =default_name.lastIndexOf(".");
//                String nameFile = default_name.substring(i,default_name.length());
               ProductService productService = factory.getService(ProductService.class);
                Product product=new Product();
                product.setType(type);
                product.setCost(cost);
                product.setName(name);
                InputStream inputStream = filePart.getInputStream();
                String encode = Base64.getEncoder().encodeToString(inputStream.readAllBytes());
                product.setImg(encode);
                productService.save(product);
            }
        }
        return null;
    }
}
