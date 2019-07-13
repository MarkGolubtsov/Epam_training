package dao.mysql;

import domain.Entity;
import exception.FitalException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DeleteByID {

    default void deleteById(String sql, Entity entity, Connection connection) throws FitalException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {throw new FitalException();}
        }
    }
}
