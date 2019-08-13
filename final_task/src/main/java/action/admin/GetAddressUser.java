package action.admin;

import action.role.ajax.AdminActionAjax;
import com.google.gson.Gson;
import domain.Address;
import exception.DBException;
import service.AddressService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetAddressUser extends AdminActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException, ServletException {
        Integer user_id =Integer.valueOf(request.getParameter("user_id"));
        AddressService addressService=factory.getService(AddressService.class);
        Address address =addressService.readByUserId(user_id);
        Gson gson = new Gson();
        String json=gson.toJson(address);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
