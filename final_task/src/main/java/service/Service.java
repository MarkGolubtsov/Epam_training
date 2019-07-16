package service;

import exception.DBException;

import java.util.List;

public interface Service<T> {

    List<T> findAll() throws DBException;
    void update(T entity) throws DBException;
}
