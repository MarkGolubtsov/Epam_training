package dao.mysql;

import action.chose_product.UserCartAction;
import exception.DBException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public abstract  class BaseMysql<T>  extends Base{
    private static Logger logger = Logger.getLogger( Base.class);

    private  PreparedStatement  fillstatmentMassive(Connection connection,int[] value,String sql) throws SQLException {
       PreparedStatement statement = connection.prepareStatement(sql);
        if (value.length<1) {
            statement.setInt(1, value[0]);
        } else {
            for (int i = 1; i <=value.length ; i++) {
                statement.setInt(i, value[i-1]);
            }
        }
        return statement;
    }
    /**
     *
     * @param sql request sql with ?
     * @param value massive of dat Elements which are substituted by a place "?"
     * @param connection
     * @throws DBException
     */
    void deleteByInt(String sql,int[] value,  Connection connection) throws DBException {
    PreparedStatement statement = null;
    try {
        statement=fillstatmentMassive(connection, value, sql);
        statement.executeUpdate();
    } catch(SQLException e) {
        logger.error(e);
        throw new DBException(e);
    } finally {
        try {
            connection.close();
            statement.close();
        } catch(SQLException | NullPointerException e) {
            logger.error(e);
        throw new DBException();}
    }
}

    /**
     * This method use for INSERT request
     * @param sql INSERT request
     * @param connection connection to database
     * @param entity the object that contains  data for the INSERT request
     * @throws DBException
     */
    Integer defultCreate(String sql, Connection connection, T entity) throws DBException {
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setFieldStatement(statement,entity);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                logger.error("There is no autoincremented index after trying to add record into table ");
                throw new DBException();
            }
        } catch(SQLException e) {
            logger.error(e);
            throw new DBException(e);
        } finally {
            try {
                connection.close();
                statement.close();
            } catch(SQLException | NullPointerException e) {
                logger.error(e);
                throw new DBException(e);}
        }
    }

    /**
     *
     * @param sql sql request
     * @param connection connection to database
     * @return List object which returt sql request
     * @throws DBException
     */
    List<T> defaultRead(String sql, Connection connection) throws DBException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            return fillList(resultSet);
        } catch (SQLException e) {
            throw new DBException(e);
        } finally {
            try {
                connection.close();
                resultSet.close();
                statement.close();
            } catch (SQLException | NullPointerException e) {
                logger.error(e);
                throw new DBException();
            }
        }
    }

    /**
     *
     * @param sql sql request
     * @param field  string value which replace "?"
     * @param connection connection to database
     * @return List object which return sql request
     * @throws DBException
     */
    List<T> readByString(String sql, String field, Connection connection) throws DBException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, field);
            resultSet = statement.executeQuery();
            return fillList(resultSet);
        } catch(SQLException e) {
            throw new DBException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch(SQLException | NullPointerException e) {

                logger.error(e);
                throw new DBException(e);
            }
        }
    }

    /**
     *
     * @param sql sql request  UPDATE
     * @param connection connection databases
     * @param entity obj which update
     * @throws DBException
     */
    void updateDefault(String sql, Connection connection, T entity) throws DBException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            setFieldStatement(statement,entity);
            setPrimary(statement,entity);
            statement.executeUpdate();
        } catch(SQLException e) {
            logger.error(e);
            throw new DBException(e);
        } finally {
            try {
                connection.close();
                statement.close();
            } catch(SQLException | NullPointerException e) {
                logger.error(e);
                throw new DBException(e);}
        }

    }

    /**
     *
     * @param connection connection database
     * @param sql sql request
     * @param value massive vlues which will replace '?'
     * @return list objects was returned by request
     * @throws DBException
     */
     List<T> readByInt(Connection connection, String sql, int[] value ) throws DBException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement=fillstatmentMassive(connection, value, sql);
            resultSet = statement.executeQuery();
            return fillList(resultSet);

        } catch (SQLException e) {
            logger.error(e);
            throw new DBException(e);
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
                logger.error(e);
                throw new DBException(e);
            }
        }

    }

    /**
     * this method create object based on data in ResultSet
     * @param resultSet result of request
     * @return returt object
     * @throws SQLException
     */
    abstract T fillFieldsObject(ResultSet resultSet) throws SQLException;


    /**
     *
     * @param statement
     * @param entity which the object stores fill will replase "?"
     * @throws SQLException
     */
    abstract void setFieldStatement(PreparedStatement statement, T entity) throws SQLException;

    /**
     * this method create  object  based on data in ResultSet
     * @param resultSet data for objects
     * @return  list with objects
     * @throws SQLException
     */
     abstract List<T> fillList(ResultSet resultSet) throws SQLException ;

    /**
     * this method fill all fields in object using data in ResultSet
     * @param obj
     * @param resultSet result of sql request
     * @throws SQLException
     */
    abstract void setParam(T obj,ResultSet resultSet) throws SQLException;

    /**
     * This method is used for UPDATE request, for searching by primary keys.
     * In this method set primary keys in statment
     * @param statement
     * @param entity
     * @throws SQLException
     */
    abstract  void setPrimary(PreparedStatement statement,T entity) throws SQLException;

}
