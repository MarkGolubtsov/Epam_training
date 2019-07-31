package service;

import exception.DBException;

import java.util.List;

public interface ServiceEntity<T> extends Service {

    List<T> findAll() throws DBException;
    void update(T entity) throws DBException;
}
