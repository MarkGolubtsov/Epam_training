package action;

import java.io.Serializable;

public class NavbarItem implements Serializable {
    private String url;
    private String name;

    public NavbarItem(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}