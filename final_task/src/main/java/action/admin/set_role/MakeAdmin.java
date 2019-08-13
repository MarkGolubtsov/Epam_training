package action.admin.set_role;

import action.admin.set_role.SetRoleUser;
import domain.RoleUser;
import domain.User;

public class MakeAdmin  extends SetRoleUser {
    @Override
    void setRole(User user) {
        user.setRole(RoleUser.ADMIN);
    }
}
