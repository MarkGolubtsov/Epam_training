package dao;

import exception.DBException;

import java.util.List;

public interface DaoEntity<Type>  extends Dao{
    Integer create(Type entity) throws DBException;

    void delete(Type entity) throws DBException;

    void update(Type entity) throws DBException;

    List<Type> read() throws DBException;

}
