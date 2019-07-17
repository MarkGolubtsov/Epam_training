package service;

import exception.DBException;

public interface ServiceFactory {
    <Type extends Service> Type getService(Class<Type> key) throws DBException;
}
