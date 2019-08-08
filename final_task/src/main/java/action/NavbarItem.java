package action;

import java.io.Serializable;

public class NavbarItem implements Serializable {
    private String url;
    private String name;
    private String icon;
    public NavbarItem(String url, String name,String icon) {
        this.url = url;
        this.name = name;
        this.icon=icon;
    }
    public String getIcon() {
        return icon;
    }
    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}