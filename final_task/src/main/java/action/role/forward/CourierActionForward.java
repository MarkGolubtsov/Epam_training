package action.role.forward;

import action.ActionWithForward;
import domain.RoleUser;

public  abstract  class CourierActionForward extends ActionWithForward {
    public  CourierActionForward() {
        getAllowRoles().add(RoleUser.COURIER);
    }
}