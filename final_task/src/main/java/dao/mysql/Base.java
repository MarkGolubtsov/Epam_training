package dao.mysql;

import java.sql.Connection;

public  abstract  class Base {
    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
