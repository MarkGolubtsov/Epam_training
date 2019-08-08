package action.role.ajax;

import action.ActionAjax;
import domain.RoleUser;

public abstract class AuthorizeActionAjax extends ActionAjax {
    public AuthorizeActionAjax() {
        getAllowRoles().add(RoleUser.USER);
        getAllowRoles().add(RoleUser.ADMIN);
        getAllowRoles().add(RoleUser.COURIER);
    }
}
