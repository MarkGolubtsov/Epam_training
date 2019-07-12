package domain;

import java.sql.Blob;

public abstract class Person extends Entity{

    private String name;
    private String password;
    private String telephone;
    private  Blob img;

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    private RoleUser roleUser;

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
