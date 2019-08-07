package action.role.forward;

import action.ActionWithForward;
import domain.RoleUser;

public abstract  class  AdminActionForward  extends ActionWithForward {
    public AdminActionForward() {
        getAllowRoles().add(RoleUser.ADMIN);
    }
}
