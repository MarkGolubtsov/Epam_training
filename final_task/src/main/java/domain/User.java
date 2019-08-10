package domain;


import java.sql.Blob;
import java.util.List;

public class User extends Entity {

    private String name;
    private String password;
    private String telephone;
    private  String img;
    private RoleUser roleUser;
    public  String getImg() {
        return img;
    }

    public void setImg( String img) {
        this.img = img;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
