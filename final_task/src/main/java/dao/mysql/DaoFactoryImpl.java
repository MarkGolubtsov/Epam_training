package dao.mysql;

import dao.*;
import dao.pool.ConnectionPool;
import exception.DBException;

import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum DaoFactoryImpl implements DaoFactory {
    INSTANСE;
    private static Map<Class<? extends Dao<?>>, Class<? extends BaseMysql>> classes = new ConcurrentHashMap<>();
    static {
        classes.put(AddressDao.class, AddressDaoImpl.class);
        classes.put(ChoseProductDao.class, ChoseProductDaoImpl.class);
        classes.put(DeliveryDao.class, DeliveryDaoImpl.class);
        classes.put(OrderDao.class, OrderDaoImpl.class);
        classes.put(ProductDao.class, ProductDaoImpl.class);
        classes.put(UserDao.class, UserDaoImpl.class);
    }




    public <Type extends Dao<?>> Type createDao(Class<Type> key) throws DBException {
        Class<? extends BaseMysql> value = classes.get(key);
        if(value != null) {
            try {
                BaseMysql dao = value.newInstance();
                Connection connection = ConnectionPool.getInstance().getConnection();
                dao.setConnection(connection);
                return (Type)dao;
            } catch(InstantiationException | IllegalAccessException e) {
                //logger.error("It is impossible to create data access object", e);
                throw new DBException(e);
            }
        }
        return null;
    }

}
