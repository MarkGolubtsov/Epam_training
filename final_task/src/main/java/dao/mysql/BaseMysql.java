package dao.mysql;

import domain.Entity;
import exception.FitalException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract  class BaseMysql<T> {
    protected Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

//    void deleteByInt(String sql,int value,  Connection connection) throws FitalException {
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, value);
//            statement.executeUpdate();
//        } catch(SQLException e) {
//            throw new FitalException(e);
//        } finally {
//            try {
//                statement.close();
//            } catch(SQLException | NullPointerException e) {throw new FitalException();}
//        }
//    }
void deleteByInt(String sql,int[] value,  Connection connection) throws FitalException {
    PreparedStatement statement = null;
    try {
        statement = connection.prepareStatement(sql);

        for (int i = 1; i <=value.length ; i++) {
            statement.setInt(i, value[i]-1);
        }
        statement.executeUpdate();
    } catch(SQLException e) {
        throw new FitalException(e);
    } finally {
        try {
            statement.close();
        } catch(SQLException | NullPointerException e) {throw new FitalException();}
    }
}

    void defultCreate(String sql, Connection connection, T entity) throws FitalException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            setFieldStatement(statement,entity);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {throw new FitalException(e);}
        }
    }

    List<T> defaultRead(String sql, Connection connection) throws FitalException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            return fillList(resultSet);
        } catch (SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                throw new FitalException();
            }
        }
    }
    List<T> readByString(String sql, String field, Connection connection) throws FitalException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, field);
            resultSet = statement.executeQuery();
            return fillList(resultSet);
        } catch(SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                resultSet.close();
            } catch(SQLException | NullPointerException e) {}
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {}
        }
    }

    void updateDefault(String sql, Connection connection, T entity) throws FitalException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            setFieldStatement(statement,entity);
            setPrimary(statement,entity);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                statement.close();
            } catch(SQLException | NullPointerException e) {throw new FitalException(e);}
        }

    }

     List<T> readByInt(Connection connection, String sql, int[] value ) throws FitalException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <=value.length ; i++) {
                statement.setInt(i, value[i]-1);
            }
            resultSet = statement.executeQuery();
            return fillList(resultSet);

        } catch (SQLException e) {
            throw new FitalException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }

    }

    abstract T fillFieldsObject(ResultSet resultSet) throws SQLException;

    abstract void setFieldStatement(PreparedStatement statement, T entity) throws SQLException;

     abstract List<T> fillList(ResultSet resultSet) throws SQLException ;

    abstract void setParam(T obj,ResultSet resultSet) throws SQLException;

    abstract  void setPrimary(PreparedStatement statement,T entity) throws SQLException;

}
