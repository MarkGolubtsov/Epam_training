package dao;

import exception.DBException;

public interface DaoFactory  {
    <Type extends Dao> Type createDao(Class<Type> key) throws DBException;
}
