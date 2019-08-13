package action.admin.set_role;

import domain.RoleUser;
import domain.User;

public class MakeCourier extends SetRoleUser {
    @Override
    void setRole(User user) {
        user.setRole(RoleUser.COURIER);
    }
}
