package action.role.ajax;

import action.ActionAjax;
import domain.RoleUser;

public  abstract  class CourierActionAjax extends ActionAjax {
    public CourierActionAjax  (){
        getAllowRoles().add(RoleUser.COURIER);
    }
}
