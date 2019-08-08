package action;

import domain.Address;
import domain.RoleUser;
import domain.User;
import exception.DBException;
import service.AddressService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends ActionWithForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
        String login =  request.getParameter("name");
        String password =  request.getParameter("password");
        String role =request.getParameter("role");
        String telephone = request.getParameter("tel");
        String street=request.getParameter("street");
        String house=request.getParameter("house");

        if (login!=null && password!=null && role!=null && telephone!=null && house!=null && street!=null) {
            Forward forward = new Forward("/shop/login");
            UserService service = null;
            service = factory.getService(UserService.class);
            User user = new User();
            user.setName(login);
            user.setTelephone(telephone);
            user.setRoleUser(RoleUser.valueOf(role));
            user.setPassword(password);
            int res = service.registration(user);
            if (res>0) {
                AddressService addressService = factory.getService(AddressService.class);
                Address address = new Address();
                user.setId(res);
                address.setUser(user);
                address.setHouse(Integer.valueOf(house));
                address.setStreet(street);
                addressService.save(address);
                return forward;
            } else {
                request.setAttribute("result", res);
                return null;
            }
        }
        return null;
    }
}
