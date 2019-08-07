package action.role.ajax;

import action.ActionAjax;
import domain.RoleUser;

public  abstract  class UserActionAjax extends ActionAjax {
    public UserActionAjax(){
        getAllowRoles().add(RoleUser.USER);
    }
}
