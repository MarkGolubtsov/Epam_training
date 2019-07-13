package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract  class BaseMysql {
    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
