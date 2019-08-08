package action.role.forward;

import action.ActionWithForward;
import domain.RoleUser;

public abstract  class AuthorizeActionForward extends ActionWithForward {
    public AuthorizeActionForward() {
        getAllowRoles().add(RoleUser.USER);
        getAllowRoles().add(RoleUser.ADMIN);
        getAllowRoles().add(RoleUser.COURIER);
    }
}
