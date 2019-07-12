package dao;

import exception.FitalException;

import java.util.List;

public interface Dao <Type> {
    void create(Type entity) throws FitalException;

    void delete(Type entity) throws FitalException;

    void update(Type entity) throws FitalException;

    List<Type> read() throws FitalException;

}
