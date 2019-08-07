package action.role.forward;

import action.ActionWithForward;
import domain.RoleUser;

public abstract class UserActionForward  extends ActionWithForward {
    public UserActionForward() {
        getAllowRoles().add(RoleUser.USER);
    }
}
