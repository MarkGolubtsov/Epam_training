package action.user;

import action.role.forward.AuthorizeActionForward;
import domain.Address;
import domain.User;
import exception.DBException;
import service.AddressService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetInfoUser extends AuthorizeActionForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {

        User user = getAuthorizedUser();
        if(user!=null) {
            AddressService addressService=factory.getService(AddressService.class);
           Address address= addressService.readByUserId(user.getId());
            String name = user.getName();
            String telephone=user.getTelephone();
            request.setAttribute("name",name);
            request.setAttribute("telephone",telephone);
            request.setAttribute("street",address.getStreet());
            request.setAttribute("house",address.getHouse());
            request.setAttribute("img",user.getImg());
        }
        return null;
    }
}
