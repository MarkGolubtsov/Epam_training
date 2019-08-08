package action.user;

import action.role.ajax.AuthorizeActionAjax;
import domain.Address;
import domain.User;
import exception.DBException;
import service.AddressService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveUserInfo extends AuthorizeActionAjax {
    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException {
        String name=request.getParameter("name");
        String tel=request.getParameter("tel");
        String street=request.getParameter("street");
        String house=request.getParameter("house");
        User user=getAuthorizedUser();
        if (user!=null && name!=null && tel!=null  && street!=null  && house!=null)
        {
            user.setTelephone(tel);
            user.setName(name);
            UserService userService= factory.getService(UserService.class);
            AddressService addressService = factory.getService(AddressService.class);
            Address address = new Address();
            address.setUser(user);
            address.setHouse(Integer.valueOf(house));
            address.setStreet(street);
            userService.update(user);
            addressService.update(address);
        }

    }
}
