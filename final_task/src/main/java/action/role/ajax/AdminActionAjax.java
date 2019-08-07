package action.role.ajax;

import action.ActionAjax;
import domain.RoleUser;

public  abstract  class AdminActionAjax  extends ActionAjax {
    public AdminActionAjax (){
        getAllowRoles().add(RoleUser.ADMIN);
    }
}