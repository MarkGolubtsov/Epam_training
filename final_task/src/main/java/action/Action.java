package action;

import domain.RoleUser;
import domain.User;
import service.ServiceFactory;

import java.util.HashSet;
import java.util.Set;

public abstract class Action {
    protected Set<RoleUser> allowRoles = new HashSet<>();
    protected User authorizedUser;
    protected String name;

    protected ServiceFactory factory;

    public Set<RoleUser> getAllowRoles() {
        return allowRoles;
    }

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFactory(ServiceFactory factory) {
        this.factory = factory;
    }
}
