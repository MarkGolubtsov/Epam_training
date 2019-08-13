package action.admin.set_role;

import domain.RoleUser;
import domain.User;

public class MakeUser extends SetRoleUser {
    @Override
    void setRole(User user) {
        user.setRole(RoleUser.USER);
    }
}
